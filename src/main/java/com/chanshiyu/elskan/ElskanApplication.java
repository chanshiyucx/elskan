package com.chanshiyu.elskan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.chanshiyu.elskan.mapper"})
@ComponentScan(basePackages = {"com.chanshiyu"})
public class ElskanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElskanApplication.class, args);
    }

}
