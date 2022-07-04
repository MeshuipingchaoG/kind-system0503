package com.chen.mapper;


import com.chen.pojo.NodeAttribute;
import com.chen.pojo.WorkflowNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeAttributeMapper {

    /**
     * 列表查询
     *
     * @param nodeAttribute   nodeAttribute
     * @return  列表
     */
    List<NodeAttribute> queryForList(NodeAttribute nodeAttribute);

    /**
     * 单个对象查询
     *
     * @param id    主键
     * @return  WorkflowProcess
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
