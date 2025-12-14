package me.yangjun.study.spring2025003;

import me.yangjun.study.spring2025003.demo20251210.service.GameStrategyServiceUtils;
import me.yangjun.study.spring2025003.demo20251214.factory.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

        service.printAllGameName();
        System.out.println("-----");

        service.printAllGameName2();
        System.out.println("-----");

        StrategyFactory sf = applicationContext.getBean(StrategyFactory.class);
        sf.getStrategy("A").ifPresent(o -> System.out.println(o.handle("A")));
        System.out.println("-----");
    }
}
