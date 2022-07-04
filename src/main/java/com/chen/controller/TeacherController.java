package com.chen.controller;

import com.chen.pojo.Teacher;
import com.chen.pojo.query.TeacherQry;
import com.chen.service.TeacherService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/initPage")
    public String findAllTea(TeacherQry teacherQry, Model model){
        teacherQry.setPageNum(1);
        teacherQry.setPageSize(10);
        PageInfo<Teacher> all = teacherService.findAll(teacherQry);
        System.out.println("教师名单"+all);
        model.addAttribute("teaList",all);
        return "admin/teacher-list";
    }

    @PostMapping("/findTeaList")
    public String findTeaList(TeacherQry teacherQry, Model model){
        PageInfo<Teacher> all = teacherService.findAll(teacherQry);
        System.out.println("教师名单"+all);
        model.addAttribute("teaList",all);
        return "admin/teacher-list :: teacher_info";
    }

    @GetMapping("/toAddTea")
    public String addTeacher(){
        return "admin/addTea";
    }

    @GetMapping("/doAddTea")
    public String doAddTea(Teacher teacher){
         teacherService.addTeacher(teacher);
        System.out.println(teacher);
        return "redirect:/teacher/initPage";
    }

    @GetMapping("/deleteTea/{id}")
    public String deleteTea(@PathVariable("id") Integer id){
        teacherService.deleteTeacher(id);
        return "redirect:/teacher/initPage";
    }

    @GetMapping("/updateTea/{id}")
    public String updateTea(@PathVariable("id") Integer id,Model model){
        Teacher teacher = teacherService.queryTeaById(id);
        model.addAttribute("Info",teacher);
        return "admin/updateTea";
    }

    @GetMapping("/doUpdateTea")
    public String doUpdateTea(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher/initPage";
    }

    /*@GetMapping("/queryByName/{userName}")
    public String queryByName(@PathVariable("userName") String userName,Model model){
        List<Teacher> teachers = teacherService.queryByName(userName);
        System.out.println("模糊查询"+teachers);
        model.addAttribute("teaList",teachers);
        return "/admin/teacher-list :: teacher_info";
        陈志威牛逼
        三生三世
    }*/
}
