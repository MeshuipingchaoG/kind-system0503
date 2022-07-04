package com.chen.mapper;


import com.chen.pojo.WorkflowProcess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkflowProcessMapper {

    /**
     * 列表查询
     *
     * @param workflowProcess   workflowProcess
     * @return  列表
     */
    List<WorkflowProcess> queryForList(WorkflowProcess workflowProcess);

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
