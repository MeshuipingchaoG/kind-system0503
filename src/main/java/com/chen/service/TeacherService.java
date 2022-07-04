package com.chen.service;

import com.chen.pojo.Teacher;
import com.chen.pojo.query.TeacherQry;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface TeacherService {

    PageInfo<Teacher> findAll(TeacherQry teacherQry);

    int addTeacher(Teacher teacher);

    int deleteTeacher(int id);

    int updateTeacher(Teacher teacher);

    Teacher queryTeaById(int id);

    //List<Teacher> queryByName(String userName);
    Teacher loginList(String username, String userpwd);

    int getUserCount(TeacherQry teacherQry);
}
