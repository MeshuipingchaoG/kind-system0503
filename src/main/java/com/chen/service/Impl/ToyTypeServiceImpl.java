package com.chen.service.Impl;

import com.chen.mapper.ToyTypeMapper;
import com.chen.pojo.ToyType;
import com.chen.pojo.query.TypeQry;
import com.chen.service.ToyTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyTypeServiceImpl implements ToyTypeService {

    @Autowired
    private ToyTypeMapper toyTypeMapper;
    @Override
    public PageInfo<ToyType> queryAllToyList(TypeQry typeQry) {
        Integer pageNum = typeQry.getPageNum();
        Integer pageSize = typeQry.getPageSize();
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ToyType> toyTypes = toyTypeMapper.queryAllToyList(typeQry);
        return new PageInfo<>(toyTypes);
    }

    @Override
    public ToyType queryToyById(int id) {
        return toyTypeMapper.queryToyById(id);
    }

    @Override
    public int addToyType(ToyType toyType) {
        return toyTypeMapper.addToyType(toyType);
    }

    @Override
    public int deleteType(int id) {
        return toyTypeMapper.deleteType(id);
    }

    @Override
    public int getTypeCount(TypeQry typeQry) {
        return toyTypeMapper.getTypeCount(typeQry);
    }

    @Override
    public int updateType(ToyType toyType) {
        return toyTypeMapper.updateType(toyType);
    }
}
