package me.yangjun.study.web;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.config.ResultDecoration;
import me.yangjun.study.vo.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Slf4j
public class TestWeb {
    @GetMapping("sayHi")
    @ResultDecoration
    // FIXME 返回字符串无法转换
    public String sayHi() {
        log.info("进入controller");
        return "hi";
    }

    @GetMapping("sayNo")
    @ResultDecoration
    // 返回对象可以转换
    public Person sayNo() {
        Person p = new Person();
        p.setName("奥巴马");
        p.setAge(10);
        return p;
    }
}
