package com.chen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.chen.mapper")
@SpringBootApplication
public class KindSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(KindSystemApplication.class, args);
    }

}
