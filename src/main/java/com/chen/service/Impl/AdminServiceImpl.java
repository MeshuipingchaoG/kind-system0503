package com.chen.service.Impl;

import com.chen.mapper.AdminMapper;
import com.chen.pojo.User;
import com.chen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<User> findAll(String username, String password) {
        return adminMapper.findAll(username,password);
    }
}
