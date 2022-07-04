package com.chen.mapper;

import com.chen.pojo.BorrowRecord;
import com.chen.pojo.query.BorrowRecordQry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterListMapper {

    List<BorrowRecord> getAll(Integer userId);

    int addRecord(BorrowRecord borrowRecord);

    BorrowRecord queryRecordById(int id);

    int updateRecord(BorrowRecord borrowRecord);

    //int deleteRecord(int id);
    int getRecordCount(BorrowRecordQry borrowRecordQry);
}
