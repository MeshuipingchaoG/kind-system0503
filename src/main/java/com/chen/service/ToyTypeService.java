package com.chen.service;

import com.chen.pojo.ToyType;
import com.chen.pojo.query.TypeQry;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ToyTypeService {

    PageInfo<ToyType> queryAllToyList(TypeQry typeQry);

    ToyType queryToyById(int id);

    int addToyType(ToyType toyType);

    int deleteType(int id);

    int getTypeCount(TypeQry typeQry);

    int updateType(ToyType toyType);
}
