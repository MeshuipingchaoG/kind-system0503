package com.chen.service;

import com.chen.pojo.User;

import java.util.List;

public interface AdminService {

    List<User> findAll(String username, String password);
}
