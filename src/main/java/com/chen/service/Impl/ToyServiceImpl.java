package com.chen.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.chen.constant.LocalConstant;
import com.chen.enums.ApproveStatusEnum;
import com.chen.enums.ApproveTypeStatusEnum;
import com.chen.enums.BorrowRecordStateEnum;
import com.chen.enums.BusinessCodeEnum;
import com.chen.mapper.ToyMapper;
import com.chen.mapper.WaterListMapper;
import com.chen.pojo.*;
import com.chen.pojo.query.ToyQry;
import com.chen.service.ApplyRecordService;
import com.chen.service.ApproveRecordService;
import com.chen.service.BusinessWorkflowRelationService;
import com.chen.service.NodeAttributeService;
import com.chen.service.ToyService;
import com.chen.service.WaterListService;
import com.chen.service.WorkflowNodeService;
import com.chen.service.WorkflowProcessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class ToyServiceImpl implements ToyService{

    @Autowired
    private ToyMapper toyMapper;

    @Autowired
    private WaterListService waterListService;

    /**
     * Autowired 和 Resource注入的区别
     * 工作流service注入
     */
    @Resource
    private WorkflowProcessService workflowProcessService;

    /**
     * 申请service
     */
    @Resource
    private ApplyRecordService applyRecordService;

    /**
     * 业务绑定工作流service
     */
    @Resource
    private BusinessWorkflowRelationService businessWorkflowRelationService;

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
     * 审批service
     */
    @Resource
    private ApproveRecordService approveRecordService;

    @Override
    public PageInfo<Toy> queryToyList(ToyQry toyQry) {

        Integer pageNum = toyQry.getPageNum();
        Integer pageSize = toyQry.getPageSize();

        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Toy> list = toyMapper.queryToyList(toyQry);
        return new PageInfo<>(list);
    }


    @Override
    public int deleteToy(int id) {
        return toyMapper.deleteToy(id);
    }

    @Override
    public int addToy(Toy toy) {
        return toyMapper.addToy(toy);
    }

    @Override
    public int updateToy(Toy toy) {
        return toyMapper.updateToy(toy);
    }

    @Override
    public Toy queryToyById(int id) {
        return toyMapper.queryToyById(id);
    }

    @Override
    public int getToyCount(ToyQry toyQry) {
        return toyMapper.getToyCount(toyQry);
    }

    @Override
    public int borrowToy(BorrowToy borrowToy, HttpSession session) {
        /*
        * 0. 库存比较
        *   a. 查出该教具的实际库存
        *   b. 跟要借的数量比较
        */
        Toy toy1 = toyMapper.queryToyById(borrowToy.getId());
        if (borrowToy.getBtoyNum() > toy1.getToyNum()) {
            // 库存不足不能借(跟前端约定好就可以，返回什么类型都可以)
            System.out.println("库存不足不能借");
            return -1;
        }

        // 原先租借记录，租借申请单(类似于借书单)，可以知道借的是什么教具，借了多少
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setBtoyNum(borrowToy.getBtoyNum());
        borrowRecord.setBdate(new Date());
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        borrowRecord.setUserId(loginUser.getId());
        borrowRecord.setToyId(borrowToy.getId());
        borrowRecord.setState(BorrowRecordStateEnum.UN_APPROVE.getState());
        // mybatis 新增记录怎么返回新增记录的id
        waterListService.addRecord(borrowRecord);
        System.out.println("生成申请单:" + JSONObject.toJSONString(borrowRecord));

        // 引入工作流的话，截断，生成租借的申请记录，并且根据配置的工作流，生成下一节点的审核记录
        /*
            1. 首先需要知道教具租借走那条工作流（业务code）BusinessCodeEnum.TOY_BORROW
                1.1 根据租借的业务code，找到教具租借业务绑定的工作流
            2. 根据工作流生产下一节点审批记录
         */
        // 流程id
        Long processId = businessWorkflowRelationService.queryProcessIdByBusinessCode(BusinessCodeEnum.TOY_BORROW.getBusinessCode());
        // 获取工作流
        if (processId == null) {
            System.out.println("未绑定教具租借流程，请联系管理员！");
            return -1;
        }
        WorkflowProcess workflowProcess = workflowProcessService.queryForObject(processId);
        // 绑定了工作流，正常提交申请
        ApplyRecord applyRecord = new ApplyRecord();
        applyRecord.setBusinessId(new Long(borrowRecord.getId()));
        applyRecord.setProcessId(workflowProcess.getId());
        applyRecord.setProcessVersion(workflowProcess.getVersion());
        applyRecord.setApplicant(new Long(loginUser.getId()));
        applyRecordService.insert(applyRecord);

        // 生产第一个节点的审批记录
        // 获取流程的第一个节点
        WorkflowNode workflowNode = new WorkflowNode();
        workflowNode.setProcessId(processId);
        // 通过开始节点找工作流的第一个审批节点
        WorkflowNode startNode = workflowNodeService.queryProcessStartNode(processId);
        if (startNode == null) {
            System.out.println("未获取流程的开始节点，生成审核记录失败！");
            return -1;
        }

        try {
            approveRecordService.productApproveRecord(startNode.getNextNodeId(), applyRecord.getId());
        } catch (Exception e) {
            // 失败之后要有事务控制
            System.out.println("租借教具失败,失败原因：" + e.getMessage());
            return -1;
        }

        return 1;
    }

    @Override
    public void realBorrowToy(Long borrowRecordId, String approveType) {
        int realId = Math.toIntExact(borrowRecordId);
        BorrowRecord borrowRecord = waterListService.queryRecordById(realId);
        // 更新租借记录的状态
        BorrowRecord updateRecord = new BorrowRecord();
        updateRecord.setId(realId);
        if (ApproveTypeStatusEnum.PASS.getType().equals(approveType)) {
            //1.更新库存
            Toy toy = toyMapper.queryToyById(borrowRecord.getToyId());
            Integer account = toy.getToyNum() - borrowRecord.getBtoyNum();
            Toy updateToy = new Toy();
            updateToy.setId(toy.getId());
            updateToy.setToyNum(account);
            toyMapper.updateToy(updateToy);

            updateRecord.setState(BorrowRecordStateEnum.BORROW_SUCCESS.getState());
        } else {
            updateRecord.setState(BorrowRecordStateEnum.BORROW_FAIL.getState());
        }
        waterListService.updateRecord(updateRecord);
    }
}
