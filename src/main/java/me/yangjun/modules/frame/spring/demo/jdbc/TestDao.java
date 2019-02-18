package me.yangjun.modules.frame.spring.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestDao implements IUser {

    //使用Spring的自动装配
    @Autowired
    private JdbcTemplate template;

    @Override
    public void save() {
        String sql = "insert into tb_test(name, sex) values('test','2')";
        template.update(sql);
    }
}
