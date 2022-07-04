package com.chen.controller;


import com.chen.pojo.ToyType;
import com.chen.pojo.query.TypeQry;
import com.chen.response.ResponseResult;
import com.chen.service.ToyTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/v1/types/")
public class ToyManageController extends BaseController{


    @Autowired
    private ToyTypeService toyTypeService;


    @GetMapping("/list")
   public ResponseResult<ToyType> getTypeList(TypeQry typeQry){
        PageInfo<ToyType> toyTypes = toyTypeService.queryAllToyList(typeQry);
        return writeSuccess(toyTypes.getList());
    }

    @GetMapping("/count")
    public ResponseResult<ToyType> getTypeCount(TypeQry typeQry){
        int typeCount = toyTypeService.getTypeCount(typeQry);
        return writeSuccess(typeCount);
    }

    @PostMapping("/addType")
    public ResponseResult<ToyType> addType(@RequestBody ToyType toyType){
        toyTypeService.addToyType(toyType);
        return writeSuccess(1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult<ToyType> deleteType(@PathVariable("id") Integer id){
        int i = toyTypeService.deleteType(id);
        System.out.println(i);
        return writeSuccess(1);
    }

    @PostMapping("/update")
    public ResponseResult<ToyType> updateType(@RequestBody ToyType toyType){
        System.out.println(toyType);
        return writeSuccess(toyTypeService.updateType(toyType));
    }

}
