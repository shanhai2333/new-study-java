package com.tree.treetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan
@SpringBootApplication
public class TreeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeTestApplication.class, args);
    }

}
