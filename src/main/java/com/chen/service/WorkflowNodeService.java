package com.chen.service;

import com.chen.pojo.WorkflowNode;
import com.github.pagehelper.PageInfo;

/**
 * @description WorkflowNodeService
 *
 * @date 2022/04/09
 */
public interface WorkflowNodeService {

    /**
     * 列表查询
     *
     * @param workflowNode   workflowNode
     * @return  列表
     */
    PageInfo<WorkflowNode> queryForList(WorkflowNode workflowNode, int page, int pageSize);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowNode
     */
    WorkflowNode queryForObject(Long id);

    /**
     * 查询某个流程的开始节点
     *
     * @param processId 流程节点
     * @return  开始节点
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
