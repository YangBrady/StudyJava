package me.yangjun.study.spring.spel;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringLog4j2Application {

    public static void main(String[] args) {
        MDC.put("userName", "哇哈哈");

        log.info("开始启动");
        SpringApplication.run(SpringLog4j2Application.class, args);
        log.info("结束启动");
    }

}
