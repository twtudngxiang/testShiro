package com.cn.xx.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cn.xx.test"})
@MapperScan("com.cn.xx.test.mybaties.dao")
@EnableAsync
public class ModelWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModelWebApplication.class, args);
    }
}
