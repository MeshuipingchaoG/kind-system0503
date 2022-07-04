package com.chen.service;

import com.chen.pojo.BusinessWorkflowRelation;
import com.github.pagehelper.PageInfo;

/**
 * @description BusinessWorkflowRelationService
 *
 * @date 2022/04/09
 */
public interface BusinessWorkflowRelationService {

    /**
     * 列表查询
     *
     * @param businessWorkflowRelation   businessWorkflowRelation
     * @return  列表
     */
    PageInfo<BusinessWorkflowRelation> queryForList(BusinessWorkflowRelation businessWorkflowRelation, int page, int pageSize);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  BusinessWorkflowRelation
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
