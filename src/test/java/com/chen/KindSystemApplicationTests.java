package com.chen;

import com.alibaba.fastjson.JSONObject;
import com.chen.enums.BusinessCodeEnum;
import com.chen.enums.WorkflowNodeTypeEnum;
import com.chen.pojo.*;
import com.chen.pojo.query.TeacherQry;
import com.chen.pojo.query.ToyQry;
import com.chen.response.ResponseResult;
import com.chen.service.*;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class KindSystemApplicationTests {

    @Resource
    private WorkflowProcessService workflowProcessService;

    /**
     * 流程节点service注入(spring bean注入)
     */
    @Resource
    private WorkflowNodeService workflowNodeService;

    /**
     * 节点属性service注入
     */
    @Resource
    private NodeAttributeService nodeAttributeService;

    /**
     * 业务绑定流程service注入
     */
    @Resource
    private BusinessWorkflowRelationService businessWorkflowRelationService;


    @Test
    void contextLoads() {
    }

    /**
     * 工作流流程测试
     */
    @Test
    void workflowProcessTest() {
        WorkflowProcess workflowProcess = new WorkflowProcess();
        workflowProcess.setName("教具租借审批流程");
        workflowProcess.setSummary("教具租借审批流程");
        Long row = workflowProcessService.insert(workflowProcess);
        System.out.println("创建工作流流程：" + row);

        WorkflowProcess query = new WorkflowProcess();
        PageInfo<WorkflowProcess> pageInfo = workflowProcessService.queryForList(query, 1, 10);
        System.out.println("查询工作流流程:" + JSONObject.toJSONString(pageInfo));

        WorkflowProcess result = workflowProcessService.queryForObject(workflowProcess.getId());
        System.out.println("查询对象:" + result);
    }

    /**
     * 创建工作流
     */
    @Test
    void createWorkflow() {
        // 创建教具租借审批流程: 提交申请 --》一级审批--》二级审批
        // 1.创建流程
        WorkflowProcess workflowProcess = new WorkflowProcess();
        workflowProcess.setName("教具租借审批流程");
        workflowProcess.setSummary("教具租借审批流程");
        workflowProcessService.insert(workflowProcess);
        Long processId = workflowProcess.getId();
        System.out.println("创建工作流流程：" + processId);

        // 2. 创建流程节点
        WorkflowNode endNode = new WorkflowNode("结束节点", WorkflowNodeTypeEnum.END_NODE.getType(), processId);
        workflowNodeService.insert(endNode);
        Long endNodeId = endNode.getId();
        System.out.println("创建结束节点：：" + endNodeId);

        WorkflowNode node2 = new WorkflowNode("二级审批", WorkflowNodeTypeEnum.PEOPLE_NODE.getType(), processId, endNodeId);
        workflowNodeService.insert(node2);
        Long node2Id = node2.getId();
        System.out.println("创建二级审批节点：：" + node2Id);
        // 创建节点对应的属性
        NodeAttribute attribute2 = new NodeAttribute();
        attribute2.setNodeId(node2Id);
        attribute2.setApprover("1025");
        nodeAttributeService.insert(attribute2);
        System.out.println("创建二级审批节点属性：：" + attribute2);

        WorkflowNode node = new WorkflowNode();
        node.setProcessId(processId);
        node.setName("一级审批");
        node.setNodeType(1);
        node.setNextNodeId(node2Id);
        workflowNodeService.insert(node);
        Long node1Id = node.getId();
        System.out.println("创建1级审批节点：：" + node1Id);
        // 创建节点对应的属性
        NodeAttribute attribute1 = new NodeAttribute();
        attribute1.setNodeId(node1Id);
        attribute1.setApprover("1008,1009");
        nodeAttributeService.insert(attribute1);
        System.out.println("创建一级审批节点属性：：" + attribute1);

        WorkflowNode startNode = new WorkflowNode("开始节点", WorkflowNodeTypeEnum.START_NODE.getType(), processId, node1Id);
        workflowNodeService.insert(startNode);
        Long startNodeId = startNode.getId();
        System.out.println("创建开始节点：：" + startNodeId);
    }

    /**
     * 业务绑定工作流
     * 给前端出接口：
     * 入参就需要工作流流程id + 业务code
     */
    @Test
    void businessBindWorkflowProcess() {
        // 已经完整的流程是12
        Long processId = 15L;
        BusinessWorkflowRelation businessRelation = new BusinessWorkflowRelation();
        businessRelation.setProcessId(processId);
        businessRelation.setBusinessCode(BusinessCodeEnum.TOY_BORROW.getBusinessCode());
        businessWorkflowRelationService.insert(businessRelation);
        System.out.println("业务绑定工作流成功：：" + businessRelation);
    }


}
