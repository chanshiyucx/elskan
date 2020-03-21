package com.chanshiyu.elskan.service;

import com.chanshiyu.elskan.model.Access;

import java.util.List;

/**
 * @author SHIYU
 * @date 2020/3/21 14:52
 * @description 访问 service
 */
public interface AccessService {

    /**
     * 创建
     */
    Access create(Access access);

    /**
     * 更新
     */
    boolean update(Access access);

    /**
     * 删除
     */
    boolean deleted(int id);

    /**
     * 查询
     */
    Access get(int id);

    /**
     * 查询列表
     */
    List<Access> list(String code);

}
