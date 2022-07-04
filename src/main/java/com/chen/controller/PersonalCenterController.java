package com.chen.controller;


import com.chen.enums.ApproveStatusEnum;
import com.chen.pojo.ApplyRecord;
import com.chen.pojo.ApplyRecordPO;
import com.chen.pojo.ApproveRecord;
import com.chen.pojo.ApproveRecordPO;
import com.chen.pojo.Teacher;
import com.chen.response.ResponseResult;
import com.chen.service.ApplyRecordService;
import com.chen.service.ApproveRecordService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/personal/")
public class PersonalCenterController extends BaseController {

    /**
     * 申请记录service
     */
    @Resource
    private ApplyRecordService applyRecordService;

    /**
     * 审批service
     */
    @Resource
    private ApproveRecordService approveRecordService;


    /**
     * 我申请的条数
     */
    @GetMapping("/apply/count")
    public ResponseResult<Integer> applyCount(ApplyRecord query, HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        if (loginUser == null) {
            return writeFail(null, "请先登录");
        }
        query.setApplicant(new Long(loginUser.getId()));
        return writeSuccess(applyRecordService.queryForCount(query));
    }

    /**
     * 我的申请
     *
     */
    @GetMapping("/myApprove")
    public ResponseResult<ApplyRecordPO> myApprove(ApplyRecord query, HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        if (loginUser == null) {
            return writeFail(null, "请先登录");
        }
        query.setApplicant(new Long(loginUser.getId()));
        PageInfo<ApplyRecordPO> applyRecordPageInfo = applyRecordService.queryForList(query, 1, 10);
        return writeSuccess(applyRecordPageInfo.getList());
    }

    /**
     * 待我审批
     */
    @GetMapping("/waitApprove")
    public ResponseResult<ApproveRecordPO> waitApprove(HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        if (loginUser == null) {
            return writeFail(null, "请先登录");
        }

        ApproveRecord query = new ApproveRecord();
        query.setApprover(new Long(loginUser.getId()));
        query.setApproveStatus(ApproveStatusEnum.UN_APPROVE.getStatus());
        PageInfo<ApproveRecordPO> approveRecordPageInfo = approveRecordService.queryForList(query, 1, 10);
        return writeSuccess(approveRecordPageInfo.getList());
    }

    /**
     * 待我审批的条数
     */
    @GetMapping("/waitApprove/count")
    public ResponseResult<Integer> waitApproveCount(HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        if (loginUser == null) {
            return writeFail(null, "请先登录");
        }
        ApproveRecord query = new ApproveRecord();
        query.setApprover(new Long(loginUser.getId()));
        query.setApproveStatus(ApproveStatusEnum.UN_APPROVE.getStatus());
        return writeSuccess(approveRecordService.queryForCount(query));
    }
}
