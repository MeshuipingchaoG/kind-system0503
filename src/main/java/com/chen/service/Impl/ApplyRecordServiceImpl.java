package com.chen.service.Impl;

import com.chen.mapper.ApplyRecordMapper;
import com.chen.pojo.ApplyRecord;
import com.chen.pojo.ApplyRecordPO;
import com.chen.pojo.BusinessWorkflowRelation;
import com.chen.pojo.MyApplyRecord;
import com.chen.pojo.query.ApplyRecordStatisticsQuery;
import com.chen.service.ApplyRecordService;
import com.chen.service.BusinessWorkflowRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description ApplyRecordServiceImpl
 *
 * @date 2022/04/09
 */
@Service("applyRecordService")
public class ApplyRecordServiceImpl implements ApplyRecordService {

    /**
     * 线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE =
            new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    @Resource
    private ApplyRecordMapper applyRecordMapper;

    @Resource
    private BusinessWorkflowRelationService businessWorkflowRelationService;

    @Override
    public PageInfo<ApplyRecordPO> queryForList(ApplyRecord applyRecord, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ApplyRecordPO> applyRecords = applyRecordMapper.queryForList(applyRecord);
        if (CollectionUtils.isEmpty(applyRecords)) {
            return new PageInfo<>();
        }

//        buildApplyRecordPageInfo(applyRecords);
        return new PageInfo<>(applyRecords);
    }

    @Override
    public int queryForCount(ApplyRecord applyRecord) {
        return applyRecordMapper.queryForCount(applyRecord);
    }

    @Override
    public ApplyRecord queryForObject(Long id) {
        return applyRecordMapper.queryForObject(id);
    }

    @Override
    public Long insert(ApplyRecord applyRecord) {
        return applyRecordMapper.insert(applyRecord);
    }

    @Override
    public int applyCount(String statisticsTime) {
        if (StringUtils.isEmpty(statisticsTime)) {
            return 0;
        }
        return applyRecordMapper.applyCount(statisticsTime);
    }
}
