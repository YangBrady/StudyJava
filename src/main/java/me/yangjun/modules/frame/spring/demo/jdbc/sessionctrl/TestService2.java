package me.yangjun.modules.frame.spring.demo.jdbc.sessionctrl;

import me.yangjun.modules.frame.spring.demo.jdbc.jdbctemplate.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService2 {

    @Autowired
    private TestDao testDao;

    @Transactional()
    public void saveData() {
        testDao.save();
        // 模拟报错
        long a = 1 / 0;
    }

    /**
     * 不会回滚
     */
    public void callSaveData() {
        this.saveData();
    }
}