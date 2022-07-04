package com.chen.mapper;


import com.chen.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AdminMapper {

    List<User> findAll(@Param("aname") String username, @Param("apwd") String password);
}
