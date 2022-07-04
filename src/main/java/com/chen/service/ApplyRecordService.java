package com.chen.service;

import com.chen.pojo.ApplyRecord;
import com.chen.pojo.ApplyRecordPO;
import com.chen.pojo.MyApplyRecord;
import com.chen.pojo.query.ApplyRecordStatisticsQuery;
import com.github.pagehelper.PageInfo;

/**
 * @description ApplyRecordService
 *
 * @date 2022/04/09
 */
public interface ApplyRecordService {

    /**
     * 列表查询
     *
     * @param applyRecord   applyRecord
     * @return  列表
     */
    PageInfo<ApplyRecordPO> queryForList(ApplyRecord applyRecord, int page, int pageSize);

    int queryForCount(ApplyRecord applyRecord);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  ApplyRecord
     */
    ApplyRecord queryForObject(Long id);

    /**
     * 插入
     *
     * @param applyRecord   applyRecord
     * @return  主键id
     */
    Long insert(ApplyRecord applyRecord);

    int applyCount(String statisticsTime);
}
