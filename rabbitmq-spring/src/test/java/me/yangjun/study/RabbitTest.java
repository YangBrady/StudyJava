package me.yangjun.study;

import me.yangjun.study.producer.MessageProducer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mooejun
 * @since 2020/6/19 10:54 上午
 */
public class RabbitTest {

	@Test
	public void sendMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
		int k = 1;
		while (k <= 10) {
			messageProducer.sendMessage("第" + k + "次发送的消息");
			k++;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
