package me.yangjun.modules.frame.spring.demo.jdbc.dao;

import me.yangjun.modules.frame.spring.demo.jdbc.bean.TestBean;

public interface ITest {
    void save(TestBean aTestBean);

    void query(String id);
}
