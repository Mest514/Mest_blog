package com.mest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: MestBlog
 * @description: 启动类
 * @author: Mest
 * @create: 2022-12-17 20:10
 **/
@SpringBootApplication
@MapperScan("com.mest.mapper")
@EnableScheduling
@EnableSwagger2
public class MestBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MestBlogApplication.class, args);
    }
}
