package com.chen.service.Impl;

import com.chen.mapper.TeacherMapper;
import com.chen.pojo.Teacher;
import com.chen.pojo.query.TeacherQry;
import com.chen.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo<Teacher> findAll(TeacherQry teacherQry) {

        Integer PageNum = teacherQry.getPageNum();
        Integer PageSize = teacherQry.getPageSize();

        if (PageNum == null || PageNum == 0) {
            PageNum = 1;
        }
        if (PageSize == null || PageSize == 0) {
            PageSize = 10;
        }
        PageHelper.startPage(PageNum,PageSize);
        List<Teacher> all = teacherMapper.findAll(teacherQry);
        return new PageInfo<>(all);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Teacher queryTeaById(int id) {
        return teacherMapper.queryTeaById(id);
    }

    @Override
    public Teacher loginList(String username, String userpwd) {
        List<Teacher> teachers = teacherMapper.loginList(username, userpwd);
        if (CollectionUtils.isEmpty(teachers) || teachers.size() > 1) {
            return null;
        }
        return teachers.get(0);
    }

    @Override
    public int getUserCount(TeacherQry teacherQry) {
        return teacherMapper.getUserCount(teacherQry);
    }
}
