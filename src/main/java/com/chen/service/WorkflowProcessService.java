package com.chen.service;

import com.chen.pojo.WorkflowProcess;
import com.github.pagehelper.PageInfo;

/**
 * @description WorkflowProcessService
 *
 * @date 2022/04/09
 */
public interface WorkflowProcessService {

    /**
     * 列表查询
     *
     * @param workflowProcess   workflowProcess
     * @return  列表
     */
    PageInfo<WorkflowProcess> queryForList(WorkflowProcess workflowProcess, int page, int pageSize);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowProcess
     */
    WorkflowProcess queryForObject(Long id);

    /**
     * 插入
     *
     * @param workflowProcess   workflowProcess
     * @return  主键id
     */
    Long insert(WorkflowProcess workflowProcess);

}
