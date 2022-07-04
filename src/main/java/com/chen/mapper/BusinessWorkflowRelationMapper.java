package com.chen.mapper;


import com.chen.pojo.BusinessWorkflowRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessWorkflowRelationMapper {

    /**
     * 列表查询
     *
     * @param businessWorkflowRelation   businessWorkflowRelation
     * @return  列表
     */
    List<BusinessWorkflowRelation> queryForList(BusinessWorkflowRelation businessWorkflowRelation);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowProcess
     */
    BusinessWorkflowRelation queryForObject(Long id);

    /**
     * 插入
     *
     * @param businessWorkflowRelation   businessWorkflowRelation
     * @return  主键id
     */
    Long insert(BusinessWorkflowRelation businessWorkflowRelation);

    /**
     * 根据业务code获取绑定的工作流流程id
     *
     * @param businessCode  业务code
     * @return  工作流流程id
     */
    Long queryProcessIdByBusinessCode(String businessCode);

    /**
     * 根据流程id查询业务场景
     *
     * @param processId     流程id
     * @return              业务code
     */
    String queryBusinessCodeByProcessId(Long processId);
}
