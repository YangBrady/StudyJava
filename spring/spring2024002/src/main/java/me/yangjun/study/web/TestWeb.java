package me.yangjun.study.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.aop.LogRecord;
import me.yangjun.study.config.log.LogRecordOperation;
import me.yangjun.study.vo.Operator;

@RestController
@RequestMapping("test")
@Slf4j
public class TestWeb {
    @GetMapping("sayHi/{word}")
    @LogRecord(category = LogRecordOperation.CREATE, success = "OkOkOK")
    public Operator sayHi(@PathVariable("word") String word) {
        log.info("进入controller {}", word);
        Operator p = new Operator();
        p.setName("奥巴马");
        p.setAge(10);
        return p;
    }
}
