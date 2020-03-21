package com.chanshiyu.elskan.model;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "source")
public class Source {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 编码信息
     */
    private String code;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}