package com.abu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.abu.ums.mapper")
public class MpGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpGeneratorApplication.class, args);
    }

}
