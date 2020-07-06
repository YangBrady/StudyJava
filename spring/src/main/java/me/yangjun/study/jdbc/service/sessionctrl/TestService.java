package me.yangjun.study.jdbc.service.sessionctrl;

import me.yangjun.study.jdbc.bean.TestBean;
import me.yangjun.study.jdbc.dao.impl.TestDao;
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

	public void normalSave() {
		TestBean aTestBean = new TestBean("normalSave", "1");
		this.testDao.save(aTestBean); // 成功
	}

	/**
	 * 模拟默认情况下报错
	 */
	public void normalSaveError() {
		TestBean aTestBean = new TestBean("normalSaveError", "1");
		this.testDao.save(aTestBean); // 成功
		long a = 1 / 0;
		TestBean aTestBean2 = new TestBean("normalSaveError", "2");
		this.testDao.save(aTestBean2); // 不会入表
	}

	/**
	 * 有异常的话当前事务全部回滚
	 * propagation ==> 事务传播级别
	 * REQUIRED:加入当前已有事务
	 * rollbackFor ==> 遇到指定异常回滚
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void sessionRequired() {
		TestBean aTestBean = new TestBean("sessionRequired", "1");
		this.testDao.save(aTestBean); // 成功
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void sessionRequiredError() {
		TestBean aTestBean = new TestBean("sessionErrorRequired", "1");
		this.testDao.save(aTestBean); // 不会入表
		long a = 1 / 0;
		TestBean aTestBean2 = new TestBean("sessionErrorRequired", "2");
		this.testDao.save(aTestBean); // 不会入表
	}

	/**
	 * 有异常的话当前事务全部回滚
	 * propagation ==> 事务传播级别
	 * NOT_SUPPORTED:以非事务方式执行
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Throwable.class)
	public void sessionNotSupportedError() {
		TestBean aTestBean = new TestBean("sessionNotSupported", "1");
		this.testDao.save(aTestBean); // 成功
		long a = 1 / 0;
		TestBean aTestBean2 = new TestBean("sessionNotSupported", "2");
		this.testDao.save(aTestBean2); // 不会入表
	}

	/**
	 * 设置只读，默认false
	 */
	@Transactional(readOnly = true)
	public void sessionReadOnly() {
		TestBean aTestBean = new TestBean("sessionReadOnly", "1");
		this.testDao.save(aTestBean); // 不会入表
		long a = 1 / 0;
		TestBean aTestBean2 = new TestBean("sessionReadOnly", "2");
		this.testDao.save(aTestBean2); // 不会入表
	}
}
