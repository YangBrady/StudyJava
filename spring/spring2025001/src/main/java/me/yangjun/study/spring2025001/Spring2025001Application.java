package me.yangjun.study.spring2025001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("me.yangjun.study.spring2025001.dao.mapper")
public class Spring2025001Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2025001Application.class, args);
    }

}
