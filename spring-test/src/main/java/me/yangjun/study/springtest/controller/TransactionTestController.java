package me.yangjun.study.springtest.controller;

import lombok.RequiredArgsConstructor;
import me.yangjun.study.springtest.service.TransactionalTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>描述：</p>
 *
 * @author: Brady Yang
 * @date: 2023/4/15  23:30
 */
@RestController
@RequestMapping("/TransactionTest")
@RequiredArgsConstructor
public class TransactionTestController {
    private final TransactionalTestService transactionalTestService;

    @GetMapping("/test00")
    public void test00() {
        transactionalTestService.test00();
    }

    @GetMapping("/test01")
    public void test01() {
        transactionalTestService.test01();
    }

    @GetMapping("/test01Fix01")
    public void test01Fix01() {
        transactionalTestService.test01Fix01();
    }

    @GetMapping("/test00Fix")
    public void test00Fix() {
        transactionalTestService.test00Fix();
    }
}
