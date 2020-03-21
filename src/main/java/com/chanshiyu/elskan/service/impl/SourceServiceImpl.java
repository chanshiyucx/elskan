package com.chanshiyu.elskan.service.impl;

import com.chanshiyu.elskan.mapper.SourceMapper;
import com.chanshiyu.elskan.model.Source;
import com.chanshiyu.elskan.service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author SHIYU
 * @date 2020/3/21 14:49
 * @description
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SourceServiceImpl implements SourceService {

    private final SourceMapper sourceMapper;

    @Override
    public Source create(Source source) {
        this.sourceMapper.insertUseGeneratedKeys(source);
        return source;
    }

    @Override
    public boolean update(Source source) {
        return this.sourceMapper.updateByPrimaryKeySelective(source) > 0;
    }

    @Override
    public boolean deleted(int id) {
        return this.sourceMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Source get(int id) {
        Example example = new Example(Source.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return this.sourceMapper.selectOneByExample(example);
    }
}
