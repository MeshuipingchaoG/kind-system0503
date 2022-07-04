package com.chen.service.Impl;

import com.chen.mapper.WorkflowNodeMapper;
import com.chen.pojo.WorkflowNode;
import com.chen.service.WorkflowNodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description WorkflowNodeServiceImpl
 *
 * @date 2022/04/09
 */
@Service("workflowNodeService")
public class WorkflowNodeServiceImpl implements WorkflowNodeService {

    @Resource
    private WorkflowNodeMapper workflowNodeMapper;

    @Override
    public PageInfo<WorkflowNode> queryForList(WorkflowNode workflowNode, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<WorkflowNode> workflowNodes = workflowNodeMapper.queryForList(workflowNode);
        return new PageInfo<>(workflowNodes);
    }

    @Override
    public WorkflowNode queryForObject(Long id) {
        return workflowNodeMapper.queryForObject(id);
    }

    @Override
    public WorkflowNode queryProcessStartNode(Long processId) {
        if (processId == null) {
            return null;
        }

        return workflowNodeMapper.queryProcessStartNode(processId);
    }

    @Override
    public Long insert(WorkflowNode workflowNode) {
        return workflowNodeMapper.insert(workflowNode);
    }
}
