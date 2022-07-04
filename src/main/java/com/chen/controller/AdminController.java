package com.chen.controller;

import com.chen.pojo.Teacher;
import com.chen.pojo.UserPO;
import com.chen.response.ResponseResult;
import com.chen.service.AdminService;
import com.chen.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;

    /*@RequestMapping("/admin")
    public String login(){
        return "/commons/login";
    }

    @PostMapping("/toLogin")
    public String toLogin(String username, String password, Model model, HttpSession session){
       // List<User> findUser = adminService.findAll(username,password);
        List<Teacher> teachers = teacherService.loginList(username, password);
        System.out.println("用户名"+username+","+"密码"+password);
        //输入的账号和密码与数据库中设置的账号密码进行比较
        if (teachers.size() > 0) {
            session.setAttribute("LoginUser",teachers.get(0));
            return  "/admin/index";
        }else {
            //提示登录失败

            model.addAttribute("msg","账号或密码错误，请重新登录");
            return "/commons/login";
        }
    }*/

    @PostMapping("/login")
    public ResponseResult<Teacher> login(@RequestBody UserPO user, HttpSession session){
        // List<User> findUser = adminService.findAll(username,password);
        System.out.println("用户名" + user.getUsername() + "," + "密码" + user.getPassword());
        Teacher teacher = teacherService.loginList(user.getUsername(), user.getPassword());
        if (teacher == null) {
            return writeFail(teacher, "用户名或密码不正确");
        }
        session.setAttribute("LoginUser",teacher);
        return writeSuccess(teacher);
    }

    @GetMapping("/signout")
    public ResponseResult<Integer> signOut(HttpServletRequest request){
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()){
            request.getSession().removeAttribute(attributeNames.nextElement());
        }
        return writeSuccess(1);
    }

    @GetMapping("/info")
    public ResponseResult<Teacher> login(HttpSession session){
        // List<User> findUser = adminService.findAll(username,password);
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        return writeSuccess(loginUser);
    }
}
