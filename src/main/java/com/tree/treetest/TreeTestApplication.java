package com.tree.treetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = {"com.tree.treetest.mapper"})
@SpringBootApplication
public class TreeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeTestApplication.class, args);
    }

}
