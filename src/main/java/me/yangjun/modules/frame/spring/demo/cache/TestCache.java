package me.yangjun.modules.frame.spring.demo.cache;

import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 缓存
 *
 * @author mooejun
 * @since 2019/05/23
 */
public class TestCache {
    /**
     * value: 缓存的名称，在 spring 配置文件中定义，必须指定至少一个
     * key:   按照SpEL表达式编写
     */
    @Cacheable(value = "myEhcache", key = "'UserMenuKey'+#userid")
    public List<String> testEhcache(String userid) {
        System.out.println("ss");
        return null;
    }
}