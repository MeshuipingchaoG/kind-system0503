package com.chen.service.Impl;

import com.chen.mapper.BusinessWorkflowRelationMapper;
import com.chen.pojo.BusinessWorkflowRelation;
import com.chen.service.BusinessWorkflowRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description BusinessWorkflowRelationServiceImpl
 *
 * @date 2022/04/09
 */
@Service("businessWorkflowRelationService")
public class BusinessWorkflowRelationServiceImpl implements BusinessWorkflowRelationService {

    @Resource
    private BusinessWorkflowRelationMapper businessWorkflowRelationMapper;

    @Override
    public PageInfo<BusinessWorkflowRelation> queryForList(BusinessWorkflowRelation businessWorkflowRelation, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<BusinessWorkflowRelation> businessWorkflowRelations = businessWorkflowRelationMapper.queryForList(businessWorkflowRelation);
        return new PageInfo<>(businessWorkflowRelations);
    }

    @Override
    public BusinessWorkflowRelation queryForObject(Long id) {
        return businessWorkflowRelationMapper.queryForObject(id);
    }

    @Override
    public Long insert(BusinessWorkflowRelation businessWorkflowRelation) {
        return businessWorkflowRelationMapper.insert(businessWorkflowRelation);
    }

    @Override
    public Long queryProcessIdByBusinessCode(String businessCode) {
        // 代码的健壮性：研发已知入参为null时会报错，进行规避
        if (StringUtils.isEmpty(businessCode)) {
            return null;
        }

        return businessWorkflowRelationMapper.queryProcessIdByBusinessCode(businessCode);
    }

    @Override
    public String queryBusinessCodeByProcessId(Long processId) {
        if (processId == null) {
            return null;
        }

        return businessWorkflowRelationMapper.queryBusinessCodeByProcessId(processId);
    }
}
