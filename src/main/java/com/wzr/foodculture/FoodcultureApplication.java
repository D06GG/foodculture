package com.wzr.foodculture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.wzr.foodculture.dao")
@EnableScheduling
public class FoodcultureApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodcultureApplication.class, args);
    }

}
