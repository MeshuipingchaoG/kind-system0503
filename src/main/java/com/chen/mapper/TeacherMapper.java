package com.chen.mapper;

import com.chen.pojo.Teacher;
import com.chen.pojo.query.TeacherQry;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    List<Teacher> findAll(TeacherQry teacherQry);

    int addTeacher(Teacher teacher);

    int deleteTeacher(int id);

    int updateTeacher(Teacher teacher);

    Teacher queryTeaById(int id);

   // List<Teacher> queryByName(String userName);
    List<Teacher> loginList(@Param("userName") String username, @Param("userPwd") String userpwd);

    int getUserCount(TeacherQry teacherQry);
}
