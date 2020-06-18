package me.yangjun.study.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mooejun
 * @since 2020/6/18 1:21 上午
 */
@Slf4j
public class ConnectionUtil {
	final static String RBAATIEMQ_IP = "192.168.3.49";
	final static int RBAATIEMQ_PORT = 5672;
	final static String VIRTUAL_HOST = "VHost_StudyJava";
	final static String RBAATIEMQ_USER = "mqroot";
	final static String RBAATIEMQ_PASSWORD = "mqroot";

	static Connection getConnection() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		// 连接 IP
		factory.setHost(RBAATIEMQ_IP);
		// 连接端口
		factory.setPort(RBAATIEMQ_PORT);
		// 虚拟机
		factory.setVirtualHost(VIRTUAL_HOST);
		// 用户
		factory.setUsername(RBAATIEMQ_USER);
		factory.setPassword(RBAATIEMQ_PASSWORD);
		// 建立连接
		return factory.newConnection();
	}

}
