package me.yangjun.study.springlog4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringLog4jApplication {

    public static void main(String[] args) {
        log.info("开始启动");
        SpringApplication.run(SpringLog4jApplication.class, args);
        log.info("结束启动");
    }

}