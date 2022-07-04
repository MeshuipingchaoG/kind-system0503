package com.chen.service.Impl;

import com.chen.enums.ApproveStatusEnum;
import com.chen.enums.ApproveTypeStatusEnum;
import com.chen.enums.BusinessCodeEnum;
import com.chen.enums.WorkflowNodeTypeEnum;
import com.chen.mapper.ApproveRecordMapper;
import com.chen.pojo.ApplyRecord;
import com.chen.pojo.ApproveRecord;
import com.chen.pojo.ApproveRecordPO;
import com.chen.pojo.NodeAttribute;
import com.chen.pojo.WorkflowNode;
import com.chen.service.ApplyRecordService;
import com.chen.service.ApproveRecordService;
import com.chen.service.BusinessWorkflowRelationService;
import com.chen.service.NodeAttributeService;
import com.chen.service.ToyService;
import com.chen.service.WorkflowNodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description ApproveRecordServiceImpl
 *
 * @date 2022/04/09
 */
@Service("approveRecordService")
public class ApproveRecordServiceImpl implements ApproveRecordService {

    @Resource
    private ApproveRecordMapper approveRecordMapper;

    /**
     * 流程节点服务
     */
    @Resource
    private WorkflowNodeService workflowNodeService;

    /**
     * 节点属性
     */
    @Resource
    private NodeAttributeService nodeAttributeService;

    /**
     * 业务绑定工作流service
     */
    @Resource
    private BusinessWorkflowRelationService businessWorkflowRelationService;

    /**
     * 教具服务
     */
    @Resource
    private ToyService toyService;

    /**
     * applyRecordService
     */
    @Resource
    private ApplyRecordService applyRecordService;

    @Override
    public PageInfo<ApproveRecordPO> queryForList(ApproveRecord approveRecord, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ApproveRecordPO> approveRecords = approveRecordMapper.queryForList(approveRecord);
        return new PageInfo<>(approveRecords);
    }

    @Override
    public int queryForCount(ApproveRecord approveRecord) {
        return approveRecordMapper.queryForCount(approveRecord);
    }

    @Override
    public ApproveRecord queryForObject(Long id) {
        return approveRecordMapper.queryForObject(id);
    }

    @Override
    public Long insert(ApproveRecord approveRecord) {
        return approveRecordMapper.insert(approveRecord);
    }

    @Override
    public void pass(Long applyId, Long approveId, Long approver) {
        // 工作流
        ApproveRecord approveRecord = new ApproveRecord();
        approveRecord.setApplyId(applyId);
        approveRecord.setApprover(approver);
        approveRecord.setApproveStatus(ApproveStatusEnum.PASS.getStatus());
        approveRecordMapper.approve(approveRecord);

        // 通过以后，生成下一节点的审批记录，如果下一节点是结束节点，则需要进行相关的业务操作
        ApproveRecord record = approveRecordMapper.queryForObject(approveId);
        Long nextNodeId = record.getNextNode();
        // 获取下一节点的节点属性
        try {
            // 结束节点标识流程结束
            WorkflowNode workflowNode = workflowNodeService.queryForObject(nextNodeId);
            if (WorkflowNodeTypeEnum.END_NODE.getType().equals(workflowNode.getNodeType())) {
                System.out.println("流程结束");
                // 处理实际的业务逻辑
                doBusiness(workflowNode.getProcessId(), applyId, ApproveTypeStatusEnum.PASS.getType());
                return;
            }
            productApproveRecord(nextNodeId, applyId);
        } catch (Exception e) {
            // 失败之后要有事务控制
            System.out.println("审核失败, 失败原因:" + e.getMessage());
        }
    }

    @Override
    public void reject(Long applyId, Long approveId, Long approver) {
        // 工作驳回
        ApproveRecord approveRecord = new ApproveRecord();
        approveRecord.setApplyId(applyId);
        approveRecord.setApprover(approver);
        approveRecord.setApproveStatus(ApproveStatusEnum.REJECT.getStatus());
        approveRecordMapper.approve(approveRecord);

        // 更新租借记录为租借失败
        ApproveRecord record = approveRecordMapper.queryForObject(approveId);
        WorkflowNode workflowNode = workflowNodeService.queryForObject(record.getCurNode());
        doBusiness(workflowNode.getProcessId(), applyId, ApproveTypeStatusEnum.REJECT.getType());
    }

    @Override
    public void productApproveRecord(Long nodeId, Long applyId) throws Exception {
        WorkflowNode workflowNode = workflowNodeService.queryForObject(nodeId);
        // 结束节点标识流程结束
        if (WorkflowNodeTypeEnum.END_NODE.getType().equals(workflowNode.getNodeType())) {
            System.out.println("流程结束");
            return;
        }

        // 生成这个节点的审批记录
        NodeAttribute nodeAttribute = nodeAttributeService.queryAttributeByNodeId(workflowNode.getId());
        String approverStr = nodeAttribute.getApprover();
        if (approverStr == null) {
            // 业务异常(实际工作中会使用自定义异常，就可以包含业务含义)
            throw new Exception("生成节点" + nodeId + "审批记录失败，失败原因：未获取到节点审批人");
        }
        // 给节点的每一审批人生成审核记录
        String[] split = approverStr.split(",");
        for (String approver : split) {
            ApproveRecord approveRecord = new ApproveRecord();
            approveRecord.setApprover(Long.parseLong(approver));
            approveRecord.setApplyId(applyId);
            approveRecord.setCurNode(nodeId);
            approveRecord.setNextNode(workflowNode.getNextNodeId());
            approveRecord.setApproveStatus(ApproveStatusEnum.UN_APPROVE.getStatus());
            this.insert(approveRecord);
        }
    }

    /**
     * 处理实际的业务逻辑
     *
     * @param processId
     * @param applyId
     */
    private void doBusiness(Long processId, Long applyId, String approveType) {
        String businessCode = businessWorkflowRelationService.queryBusinessCodeByProcessId(processId);
        // 如果是教具租借
        if (BusinessCodeEnum.TOY_BORROW.getBusinessCode().equals(businessCode)) {
            ApplyRecord applyRecord = applyRecordService.queryForObject(applyId);
            Long businessId = applyRecord.getBusinessId();
            // 做实际业务
            toyService.realBorrowToy(businessId, approveType);
        } else if (BusinessCodeEnum.TOY_BUY_APPLY.getBusinessCode().equals(businessCode)) {

        }
    }
}
