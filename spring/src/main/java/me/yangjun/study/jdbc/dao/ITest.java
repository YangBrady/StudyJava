package me.yangjun.study.jdbc.dao;

import me.yangjun.study.jdbc.bean.TestBean;

public interface ITest {
    void save(TestBean aTestBean);

    void query(String id);
}
