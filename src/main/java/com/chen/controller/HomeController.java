package com.chen.controller;

import com.chen.pojo.query.ApplyRecordStatisticsQuery;
import com.chen.response.ResponseResult;
import com.chen.service.ApplyRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 审批Controller
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * 申请记录service
     */
    @Resource
    private ApplyRecordService applyRecordService;
    /**
     * 同意
     *
     */
    @GetMapping("/applyCount/{statisticsTime}")
    public ResponseResult<Integer> applyCount(@PathVariable("statisticsTime") String statisticsTime) {
        return writeSuccess(applyRecordService.applyCount(statisticsTime));
    }

}
