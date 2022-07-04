package com.chen.mapper;

import com.chen.pojo.Toy;
import com.chen.pojo.query.ToyQry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyMapper {

    List<Toy> queryToyList(ToyQry toyQry);

    int deleteToy(int id);

    int addToy(Toy toy);

    int updateToy(Toy toy);

    Toy queryToyById(int id);



   // List<Toy> queryByTypeId(int typeId);

    int getToyCount(ToyQry toyQry);




}
