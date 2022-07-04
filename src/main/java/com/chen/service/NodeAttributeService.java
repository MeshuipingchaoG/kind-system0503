package com.chen.service;

import com.chen.pojo.NodeAttribute;
import com.github.pagehelper.PageInfo;

/**
 * @description NodeAttributeService
 *
 * @date 2022/04/09
 */
public interface NodeAttributeService {

    /**
     * 列表查询
     *
     * @param nodeAttribute   nodeAttribute
     * @return  列表
     */
    PageInfo<NodeAttribute> queryForList(NodeAttribute nodeAttribute, int page, int pageSize);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  NodeAttribute
     */
    NodeAttribute queryForObject(Long id);

    /**
     * 通过节点id查询节点属性
     *
     * @param nodeId    节点id
     * @return  NodeAttribute
     */
    NodeAttribute queryAttributeByNodeId(Long nodeId);

    /**
     * 插入
     *
     * @param nodeAttribute   nodeAttribute
     * @return  主键id
     */
    Long insert(NodeAttribute nodeAttribute);

}
