package com.chanshiyu.elskan.service.impl;

import com.chanshiyu.elskan.mapper.AccessMapper;
import com.chanshiyu.elskan.model.Access;
import com.chanshiyu.elskan.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author SHIYU
 * @date 2020/3/21 14:55
 * @description
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccessServiceImpl implements AccessService {

    private final AccessMapper accessMapper;

    @Override
    public Access create(Access access) {
        access.setCreateTime(new Date());
        this.accessMapper.insertUseGeneratedKeys(access);
        return access;
    }

    @Override
    public boolean update(Access access) {
        return this.accessMapper.updateByPrimaryKeySelective(access) > 0;
    }

    @Override
    public boolean deleted(int id) {
        return this.accessMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Access get(int id) {
        Example example = new Example(Access.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return this.accessMapper.selectOneByExample(example);
    }

    @Override
    public List<Access> list(String code) {
        Example example = new Example(Access.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code", code);
        return this.accessMapper.selectByExample(example);
    }
}
