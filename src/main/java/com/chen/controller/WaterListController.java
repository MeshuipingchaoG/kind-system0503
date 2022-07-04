package com.chen.controller;


import com.chen.pojo.Teacher;
import com.chen.pojo.Toy;
import com.chen.pojo.ToyType;
import com.chen.pojo.BorrowRecord;
import com.chen.pojo.query.BorrowRecordQry;
import com.chen.pojo.query.ToyQry;
import com.chen.pojo.query.TypeQry;
import com.chen.response.ResponseResult;
import com.chen.service.ToyService;
import com.chen.service.ToyTypeService;
import com.chen.service.WaterListService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/record")
public class WaterListController extends BaseController{

    @Autowired
    private WaterListService waterListService;

    @Autowired
    private ToyService toyService;

    @Autowired
    private ToyTypeService toyTypeService;

    @GetMapping("/getAllRecord")
    public ResponseResult<BorrowRecord> getAllRecord(HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        /**
         * 判断身份是否为管理员，是管理员 userId = null
         */
        System.out.println("session里的信息" + loginUser);
        if (loginUser.getRole() == 1){

            loginUser.setId(null);

        }
        List<BorrowRecord> all = waterListService.getAll(loginUser.getId());
        System.out.println("记录====>"+all);
        return writeSuccess(all);
    }

    @GetMapping("/count")
    public ResponseResult<BorrowRecord> getRecordCount(BorrowRecordQry borrowRecordQry){
        int recordCount = waterListService.getRecordCount(borrowRecordQry);
        return writeSuccess(recordCount);
    }
    @GetMapping("/initPage")
    public String initPage(Model model) {
        ToyQry toyQry = new ToyQry();
        toyQry.setPageNum(1);
        toyQry.setPageSize(10);
        PageInfo<Toy> toys = toyService.queryToyList(toyQry);
        //List<ToyType> toyTypes = toyTypeService.queryAllToyList();

        model.addAttribute("toyList",toys);
       // model.addAttribute("types",toyTypes);
        System.out.println("=====" + toys);
        return "/user/bToyList";
    }

    @PostMapping("/findList")
    public String findList(ToyQry toyQry, Model model){
        PageInfo<Toy> toys = toyService.queryToyList(toyQry);
        model.addAttribute("toyList",toys);
        System.out.println("=====" + toys);
        return "/user/bToyList :: toy_data";
    }

    @PostMapping("/returnToy")
    public ResponseResult<Integer> returnToy(@RequestBody BorrowRecord borrowRecord){
        Toy toy = new Toy();
        borrowRecord.getToyId();
        borrowRecord.getBtoyNum();
        toy.setId(borrowRecord.getToyId());
        Toy toy1 = toyService.queryToyById(borrowRecord.getToyId());
        toy.setToyNum(toy1.getToyNum());
        int i = waterListService.returnToy(borrowRecord, toy);
        return writeSuccess(i);
    }
}
