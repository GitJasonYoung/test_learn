package com.test.learn;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jason
 * @Description
 * @date 2021/06/30 星期三
 */
@SpringBootApplication
//@EnableScheduling
public class TestLearnApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestLearnApplication.class);
        SpringApplication.run(TestLearnApplication.class,args);
    }
}
