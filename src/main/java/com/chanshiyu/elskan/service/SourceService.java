package com.chanshiyu.elskan.service;

import com.chanshiyu.elskan.model.Source;

/**
 * @author SHIYU
 * @date 2020/3/21 14:46
 * @description 来源 service
 */
public interface SourceService {

    /**
     * 创建
     */
    Source create(Source source);

    /**
     * 更新
     */
    boolean update(Source source);

    /**
     * 删除
     */
    boolean deleted(int id);

    /**
     * 查询
     */
    Source get(int id);

}
