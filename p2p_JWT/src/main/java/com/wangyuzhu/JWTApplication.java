package com.wangyuzhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wangyuzhu.mapper")
public class JWTApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWTApplication.class,args);
    }

}
