package me.yangjun.study.springtest.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>描述：测试异步请求参数问题</p>
 *
 * @author: Brady Yang
 * @date: 2023/3/12  17:44
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/asyncRequest")
public class AsyncRequestController {

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        String age1 = request.getParameter("age");
        String name1 = request.getParameter("name");
        log.info("arg1={}, name1={}", age1, name1);
        new Thread(() -> {
            String age2 = request.getParameter("age");
            String name2 = request.getParameter("name");
            log.info("age2={}, name2={}", age2, name2);
        }).start();
        return "get success";
    }

    @GetMapping("/testWithSleep")
    public String testWithSleep(HttpServletRequest request) {
        String age1 = request.getParameter("age");
        String name1 = request.getParameter("name");
        log.info("arg1={}, name1={}", age1, name1);
        new Thread(() -> {
            String age2 = request.getParameter("age");
            String name2 = request.getParameter("name");
            log.info("age2={}, name2={}", age2, name2);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            age2 = request.getParameter("age");
            name2 = request.getParameter("name");
            log.info("age2={}, name1={}", age2, name2);
        }).start();
        return "get success";
    }

}
