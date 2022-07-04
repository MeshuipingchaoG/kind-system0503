package com.chen.service.Impl;

import com.chen.mapper.WaterListMapper;
import com.chen.pojo.BorrowRecord;
import com.chen.pojo.Toy;
import com.chen.pojo.query.BorrowRecordQry;
import com.chen.pojo.query.RecordQry;
import com.chen.service.ToyService;
import com.chen.service.WaterListService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WaterListServiceImpl implements WaterListService {

    @Autowired
    private WaterListMapper waterListMapper;

    @Autowired
    private ToyService toyService;

    @Override
    public List<BorrowRecord> getAll(Integer userId) {

        return waterListMapper.getAll(userId);
    }

    @Override
    public int addRecord(BorrowRecord borrowRecord) {

        return waterListMapper.addRecord(borrowRecord);
    }


    @Override
    public int updateRecord(BorrowRecord borrowRecord) {
        return waterListMapper.updateRecord(borrowRecord);
    }


    @Override
    public int returnToy(BorrowRecord borrowRecord, Toy toy) {

        BorrowRecord borrowRecord1 = waterListMapper.queryRecordById(borrowRecord.getId());
        Integer btoyNum = borrowRecord1.getBtoyNum();  //查找到借的数量
        System.out.println("借的数量:"+btoyNum);

        Toy toy1 = toyService.queryToyById(toy.getId());  //通过查询到物品
        Integer toyNum = toy1.getToyNum();  //剩余库存
        System.out.println("剩余库存: "+toyNum);

        Integer sum = btoyNum + toyNum; //归还后的数量
        System.out.println("归还后的数量: " + sum);

        //更新库存数量
        Toy updateToy = new Toy();
        updateToy.setId(toy.getId());
        updateToy.setToyNum(sum);
        toyService.updateToy(updateToy);

        //更新记录表的归还时间，
        borrowRecord.setRdate(new Date());
        borrowRecord.setState(2);
        return waterListMapper.updateRecord(borrowRecord);
    }

    @Override
    public BorrowRecord queryRecordById(Integer id) {
        if (id == null) {
            return null;
        }

        return waterListMapper.queryRecordById(id);
    }

    @Override
    public int getRecordCount(BorrowRecordQry borrowRecordQry) {
        return waterListMapper.getRecordCount(borrowRecordQry);
    }
}
