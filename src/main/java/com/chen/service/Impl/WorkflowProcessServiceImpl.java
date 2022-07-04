package com.chen.service.Impl;

import com.chen.mapper.WorkflowProcessMapper;
import com.chen.pojo.WorkflowProcess;
import com.chen.service.WorkflowProcessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description WorkflowProcessServiceImpl
 *
 * @date 2022/04/09
 */
@Service("workflowProcessService")
public class WorkflowProcessServiceImpl implements WorkflowProcessService {

    @Resource
    private WorkflowProcessMapper workflowProcessMapper;

    @Override
    public PageInfo<WorkflowProcess> queryForList(WorkflowProcess workflowProcess, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<WorkflowProcess> workflowProcesses = workflowProcessMapper.queryForList(workflowProcess);
        return new PageInfo<>(workflowProcesses);
    }

    @Override
    public WorkflowProcess queryForObject(Long id) {
        return workflowProcessMapper.queryForObject(id);
    }

    @Override
    public Long insert(WorkflowProcess workflowProcess) {
        return workflowProcessMapper.insert(workflowProcess);
    }
}
