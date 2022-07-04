package com.chen.controller;


import com.chen.pojo.BorrowToy;
import com.chen.pojo.Toy;
import com.chen.pojo.ToyType;
import com.chen.pojo.query.ToyQry;
import com.chen.response.ResponseResult;
import com.chen.service.ToyService;
import com.chen.service.ToyTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/toys/")
public class ToyController extends BaseController{

    @Autowired
    private ToyService toyService;

    @GetMapping("/findList")
    public ResponseResult<Toy> getToyList(ToyQry toyQry){
        PageInfo<Toy> toys = toyService.queryToyList(toyQry);
        System.out.println(toys);
        return writeSuccess(toys.getList());
    }

    @GetMapping("/count")
    public ResponseResult<Toy> getToyCount(ToyQry toyQry){
        return writeSuccess(toyService.getToyCount(toyQry));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseResult<Toy> deleteToy(@PathVariable("id") int id){
        toyService.deleteToy(id);
        return writeSuccess(1);
    }

    @PostMapping("/addToy")
    public ResponseResult<Integer> addToy(@RequestBody Toy toy){
        toyService.addToy(toy);
        System.out.println(toy);
        return writeSuccess(1);

   }

   @PostMapping("/update")
   public ResponseResult<Toy> updateToy(@RequestBody Toy toy){
       System.out.println(toy);
       int i = toyService.updateToy(toy);
       return writeSuccess(i);
   }

    @PostMapping("/borrowToy")
    public ResponseResult<Toy> borrowToy(@RequestBody BorrowToy borrowToy, HttpSession session) {
        // 我要借的数量
        toyService.borrowToy(borrowToy, session);
        return writeSuccess(1);
    }






}
