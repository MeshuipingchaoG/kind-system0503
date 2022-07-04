package com.chen.controller;

import com.chen.pojo.Teacher;
import com.chen.pojo.User;
import com.chen.pojo.query.TeacherQry;
import com.chen.response.ResponseResult;
import com.chen.service.TeacherService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users/")
public class UserController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public ResponseResult<Teacher> getUserList(TeacherQry teacherQry){
        PageInfo<Teacher> all = teacherService.findAll(teacherQry);
        return writeSuccess(all.getList());
    }

    @GetMapping("/count")
    public ResponseResult<Teacher> getUserCount(TeacherQry teacherQry){
        return writeSuccess(teacherService.getUserCount(teacherQry));
    }

    @PostMapping("/add")
    public ResponseResult<Integer> addUser(@RequestBody Teacher teacher){
        System.out.println(teacher);
        teacherService.addTeacher(teacher);
        return writeSuccess(1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult<User> deleteUser(@PathVariable("id") Integer id){
        int i = teacherService.deleteTeacher(id);
        System.out.println("1表示删除成功:" + i);
        return writeSuccess(1);
    }

    @PostMapping("/update")
    public ResponseResult<User> updateUser(@RequestBody Teacher teacher){
        System.out.println(teacher);
        return writeSuccess( teacherService.updateTeacher(teacher));
    }
}
