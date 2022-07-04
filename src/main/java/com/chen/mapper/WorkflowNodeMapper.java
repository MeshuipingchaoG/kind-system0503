package com.chen.mapper;


import com.chen.pojo.WorkflowNode;
import com.chen.pojo.WorkflowProcess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkflowNodeMapper {

    /**
     * 列表查询
     *
     * @param WorkflowNode   workflowNode
     * @return  列表
     */
    List<WorkflowNode> queryForList(WorkflowNode WorkflowNode);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowProcess
     */
    WorkflowNode queryForObject(Long id);

    /**
     * 查询某个流程的开始节点
     *
     * @param processId 流程节点
     * @return 开始节点
     */
    WorkflowNode queryProcessStartNode(Long processId);

    /**
     * 插入
     *
     * @param workflowNode   workflowNode
     * @return  主键id
     */
    Long insert(WorkflowNode workflowNode);

}
