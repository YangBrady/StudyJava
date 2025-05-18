package me.yangjun.study.spring2025003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import me.yangjun.study.spring2025003.service.GameStrategyServiceUtils;

@SpringBootApplication
public class Spring2025003Application implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Spring2025003Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GameStrategyServiceUtils service = applicationContext.getBean(GameStrategyServiceUtils.class);
        // service.printAllGameName();
        service.printAllGameName2();
    }
}
