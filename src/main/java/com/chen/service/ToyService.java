package com.chen.service;

import com.chen.pojo.BorrowToy;
import com.chen.pojo.Toy;
import com.chen.pojo.query.ToyQry;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ToyService {

    PageInfo<Toy> queryToyList(ToyQry toyQry);

    int deleteToy(int id);

    int addToy(Toy toy);

    int updateToy(Toy toy);

    Toy queryToyById(int id);

   // List<Toy> queryByTypeId(int typeId);
   int getToyCount(ToyQry toyQry);

    int borrowToy(BorrowToy borrowToy, HttpSession session);

    /**
     * 完成教具的租借
     *
     * @param borrowRecordId    租借申请记录id
     */
    void realBorrowToy(Long borrowRecordId, String approveType);


}
