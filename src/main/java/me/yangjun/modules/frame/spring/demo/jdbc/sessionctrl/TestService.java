package me.yangjun.modules.frame.spring.demo.jdbc.sessionctrl;

import me.yangjun.modules.frame.spring.demo.jdbc.jdbctemplate.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public void saveData() {
        testDao.save();
        long a = 1 / 0;
        testDao.save();
    }
}
