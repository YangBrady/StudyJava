package me.yangjun.modules.frame.spring.demo.jdbc.service.sessionctrl;

import me.yangjun.modules.frame.spring.demo.jdbc.bean.TestBean;
import me.yangjun.modules.frame.spring.demo.jdbc.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务控制
 */
@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    /**
     * 模拟默认情况下报错
     */
    public void normalErrorSave(TestBean aTestBean) {
        this.testDao.save(aTestBean); // 会入表
        long a = 1 / 0;
        this.testDao.save(aTestBean); // 不会入表
    }

    /**
     * 加入事务控制，默认事务控制
     */
    @Transactional()
    public void sessionSave(TestBean aTestBean) {
        this.testDao.save(aTestBean);
    }

    /**
     * 加入事务控制，默认事务控制，报错全部回滚
     */
    @Transactional()
    public void sessionErrorSave(TestBean aTestBean) {
        this.testDao.save(aTestBean); // 不会入表
        long a = 1 / 0;
        this.testDao.save(aTestBean); // 不会入表
    }

    /**
     * 有异常的话当前事务全部回滚
     * propagation ==> 事务传播级别
     *                 REQUIRED:加入当前已有事务
     * rollbackFor ==> 遇到指定异常回滚
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.Throwable.class)
    public void sessionRequired(TestBean aTestBean) {
        this.testDao.save(aTestBean);
        long a = 1 / 0;
        this.testDao.save(aTestBean);
    }

    /**
     * 有异常的话当前事务全部回滚
     * propagation ==> 事务传播级别
     *                 NOT_SUPPORTED:以非事务方式执行
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = java.lang.Throwable.class)
    public void sessionNotSupported(TestBean aTestBean) {
        this.testDao.save(aTestBean);
        long a = 1 / 0;
        this.testDao.save(aTestBean);
    }

    /**
     * 设置只读，默认false
     */
    @Transactional(readOnly = true)
    public void sessionReadOnly(TestBean aTestBean) {
        this.testDao.save(aTestBean);
        long a = 1 / 0;
        this.testDao.save(aTestBean);
    }
}
