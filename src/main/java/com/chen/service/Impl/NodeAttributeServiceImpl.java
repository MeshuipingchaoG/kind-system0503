package com.chen.service.Impl;

import com.chen.mapper.NodeAttributeMapper;
import com.chen.pojo.NodeAttribute;
import com.chen.service.NodeAttributeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description NodeAttributeServiceImpl
 *
 * @date 2022/04/09
 */
@Service("nodeAttributeService")
public class NodeAttributeServiceImpl implements NodeAttributeService {

    @Resource
    private NodeAttributeMapper nodeAttributeMapper;

    @Override
    public PageInfo<NodeAttribute> queryForList(NodeAttribute nodeAttribute, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<NodeAttribute> nodeAttributes = nodeAttributeMapper.queryForList(nodeAttribute);
        return new PageInfo<>(nodeAttributes);
    }

    @Override
    public NodeAttribute queryForObject(Long id) {
        return nodeAttributeMapper.queryForObject(id);
    }

    @Override
    public Long insert(NodeAttribute nodeAttribute) {
        return nodeAttributeMapper.insert(nodeAttribute);
    }

    @Override
    public NodeAttribute queryAttributeByNodeId(Long nodeId) {
        return nodeAttributeMapper.queryAttributeByNodeId(nodeId);
    }
}
