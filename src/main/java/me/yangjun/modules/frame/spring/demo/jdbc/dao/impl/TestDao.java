package me.yangjun.modules.frame.spring.demo.jdbc.dao.impl;

import me.yangjun.modules.frame.spring.demo.jdbc.bean.TestBean;
import me.yangjun.modules.frame.spring.demo.jdbc.dao.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class TestDao implements ITest {

    //使用Spring的自动装配
    @Autowired
    private JdbcTemplate template;

    @Override
    public void save(TestBean aTestBean) {
        String sql = "insert into tb_test(name, sex) values('" + aTestBean.getName() + "' ,'" + aTestBean.getSex() + "')";
        template.update(sql);
    }

    @Override
    public void query(String id) {
        String sql = "select * from tb_test where id=?";
        List<TestBean> testBeanList = template.query(sql, new RowMapper<TestBean>() {
            @Override
            public TestBean mapRow(ResultSet resultSet, int i) throws SQLException {
                TestBean testBean = new TestBean();
                testBean.setId(resultSet.getString("id"));
                testBean.setName(resultSet.getString("name"));
                testBean.setSex(resultSet.getString("sex"));
                return testBean;
            }
        }, id);
        System.out.println(testBeanList);
    }
}
