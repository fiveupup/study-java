package com.metayoo.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.metayoo"})
@MapperScan(basePackages = {"com.metayoo.study.mapper"})
public class AppTest {
    public static void main(String[] args) {
        SpringApplication.run(AppTest.class, args);
    }
}
