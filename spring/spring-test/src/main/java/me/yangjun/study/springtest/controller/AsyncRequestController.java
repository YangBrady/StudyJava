package me.yangjun.study.springtest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * <p>描述：测试异步请求参数问题</p>
 * <p>参考博客：
 * <a href="https://www.cnblogs.com/mysgk/p/16470336.html">springboot 中如何正确的在异步线程中使用request </a>
 * <a href="https://www.cnblogs.com/thisiswhy/p/16539739.html">关于Request复用的那点破事儿。研究明白了，给你汇报一下。 </a>
 * </p>
 *
 * @author: Brady Yang
 * @date: 2023/3/12  17:44
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/asyncRequest")
public class AsyncRequestController {

    private static void getParamAndPrint(HttpServletRequest request) {
        String age = request.getParameter("age");
        String name = request.getParameter("name");
        log.info("age={}, name={}", age, name);
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        getParamAndPrint(request);
        new Thread(() -> {
            getParamAndPrint(request);
        }).start();
        return "get success";
    }

    @GetMapping("/testWithSleep")
    public String testWithSleep(HttpServletRequest request) {
        getParamAndPrint(request);
        new Thread(() -> {
            getParamAndPrint(request);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getParamAndPrint(request);
        }).start();
        return "get success";
    }
}
