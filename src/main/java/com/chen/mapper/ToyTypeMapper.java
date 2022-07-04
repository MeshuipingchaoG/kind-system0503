package com.chen.mapper;

import com.chen.pojo.ToyType;
import com.chen.pojo.query.TypeQry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToyTypeMapper {

    List<ToyType> queryAllToyList(TypeQry typeQry);

    ToyType queryToyById(int id);

    int addToyType(ToyType toyType);

    int deleteType(int id);

    int getTypeCount(TypeQry typeQry);

    int updateType(ToyType toyType);


}
