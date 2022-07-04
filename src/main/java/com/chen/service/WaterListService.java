package com.chen.service;

import com.chen.pojo.BorrowRecord;
import com.chen.pojo.Toy;
import com.chen.pojo.query.BorrowRecordQry;
import com.chen.pojo.query.RecordQry;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WaterListService {

    /**
     *
     * @param userId
     * @return
     */
    List<BorrowRecord> getAll(Integer userId);

    //新增一条流水记录
    int addRecord(BorrowRecord borrowRecord);

    /**
     * 归还结局
     *
     * @param borrowRecord
     * @param toy
     * @return
     */
    int returnToy(BorrowRecord borrowRecord, Toy toy);

    int updateRecord(BorrowRecord borrowRecord);

    /**
     * 根据id查询
     *
     * @param id    主键
     * @return      BorrowRecord
     */
    BorrowRecord queryRecordById(Integer id);

    int getRecordCount(BorrowRecordQry borrowRecordQry);
}
