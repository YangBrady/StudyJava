package me.yangjun.study.web;

import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.entity.OrderEntity;
import me.yangjun.study.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoWeb {
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/test1/{id}")
    public String hello(@PathVariable("id") Long id) {
        OrderEntity orderEntity = orderMapper.selectById(id);
        log.info("orderEntity={}", orderEntity);
        return "ok";
    }
}
