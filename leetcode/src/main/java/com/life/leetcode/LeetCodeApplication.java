package com.life.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})//此处禁用数据库连接和MongoDB的连接
public class LeetCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetCodeApplication.class, args);
    }

}
