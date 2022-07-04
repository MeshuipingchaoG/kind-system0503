package com.chen.mapper;


import com.chen.pojo.ApproveRecord;
import com.chen.pojo.ApproveRecordPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApproveRecordMapper {

    /**
     * 列表查询
     *
     * @param approveRecord   approveRecord
     * @return  列表
     */
    List<ApproveRecordPO> queryForList(ApproveRecord approveRecord);

    int queryForCount(ApproveRecord approveRecord);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowProcess
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
     * 更新
     *
     * @param approveRecord     approveRecord
     * @return  影响条数
     */
    int update(ApproveRecord approveRecord);

    /**
     * 审批操作
     *
     * @param approveRecord
     * @return
     */
    int approve(ApproveRecord approveRecord);

}
