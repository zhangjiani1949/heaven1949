package com.heaven.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.heaven.demo.mapper")
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        /*SpringApplication application = new SpringApplication(SpringBootDemoApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);*/
        System.out.println(SpringApplication.run(SpringBootDemoApplication.class, args));
    }

}
