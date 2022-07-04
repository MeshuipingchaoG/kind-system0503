package com.chen.controller;

import com.chen.pojo.Teacher;
import com.chen.response.ResponseResult;
import com.chen.service.ApproveRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 审批Controller
 */
@RestController
@RequestMapping("/approve")
public class ApproveController extends BaseController {

    /**
     * 审批service
     */
    @Resource
    private ApproveRecordService approveRecordService;

    /**
     * 同意
     *
     */
    @GetMapping("/pass")
    public ResponseResult<String> pass(Long applyId, Long approveId, HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        if (loginUser == null) {
            return writeFail("审核通过失败", "请先登录");
        }
        Long approver = new Long(loginUser.getId());
        approveRecordService.pass(applyId, approveId, approver);
        return writeSuccess("审核通过");
    }

    /**
     * 驳回
     */
    @GetMapping("/reject")
    public ResponseResult<String> reject(Long applyId, Long approveId, HttpSession session) {
        Teacher loginUser = (Teacher) session.getAttribute("LoginUser");
        if (loginUser == null) {
            return writeFail("审核驳回失败", "请先登录");
        }
        Long approver = new Long(loginUser.getId());
        approveRecordService.reject(applyId, approveId, approver);
        return writeSuccess("审核驳回");
    }
}
