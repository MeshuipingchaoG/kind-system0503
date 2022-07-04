package com.chen.mapper;


import com.chen.pojo.ApplyRecord;
import com.chen.pojo.ApplyRecordPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRecordMapper {

    /**
     * 列表查询
     *
     * @param applyRecord   applyRecord
     * @return  列表
     */
    List<ApplyRecordPO> queryForList(ApplyRecord applyRecord);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowProcess
     */
    ApplyRecord queryForObject(Long id);

    /**
     * 插入
     *
     * @param applyRecord   applyRecord
     * @return  主键id
     */
    Long insert(ApplyRecord applyRecord);

    /**
     * 查询数量
     */
    int queryForCount(ApplyRecord applyRecord);

    /**
     * 申请数量统计
     * @param statisticsTime
     * @return
     */
    int applyCount(String statisticsTime);

}
