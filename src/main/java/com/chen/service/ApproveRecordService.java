package com.chen.service;

import com.chen.pojo.ApproveRecord;
import com.chen.pojo.ApproveRecordPO;
import com.github.pagehelper.PageInfo;

/**
 * @description ApproveRecordService
 *
 * @date 2022/04/09
 */
public interface ApproveRecordService {

    /**
     * 列表查询
     *
     * @param approveRecord   approveRecord
     * @return  列表
     */
    PageInfo<ApproveRecordPO> queryForList(ApproveRecord approveRecord, int page, int pageSize);

    /**
     * 查询条数
     */
    int queryForCount(ApproveRecord approveRecord);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  ApproveRecord
     */
    ApproveRecord queryForObject(Long id);

    /**
     * 插入
     *
     * @param approveRecord   approveRecord
     * @return  主键id
     */
    Long insert(ApproveRecord approveRecord);

    /**
     * 同意
     *
     * @param approveId     审批流id
     * @param applyId       申请id
     */
    void pass(Long applyId, Long approveId, Long approver);

    /**
     * 同意
     *
     * @param applyId       申请id
     */
    void reject(Long applyId, Long approveId, Long approver);

    /**
     * 生成某个节点的审批记录
     *
     * @param nodeId    节点id
     * @param applyId   申请id
     */
    void productApproveRecord(Long nodeId, Long applyId) throws Exception;
}
