package me.yangjun.study.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author mooejun
 * @since 2020/6/18 10:28 上午
 */
public class MyProducer {
	private final static String EXCHANGE_NAME = "WORK_EXCHANGE";
	private final static String ROUTING_KEY = "WORK_ROUTING_KEY";

	public static void main(String[] args) throws Exception {
		// 获取连接
		Connection conn = ConnectionUtil.getConnection();
		// 声明信道
		Channel channel = conn.createChannel();

		// 定义消息内容(发布多条消息)
		for (int i = 0; i < 50; i++) {
			String msg = "hello rabbitmq " + i;
			// 发布消息
			channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, msg.getBytes());
			System.out.println("[x] Sent'" + msg + "'");
			// 模拟发送消息延时，便于演示多个消费者竞争接受消息
			Thread.sleep(i * 10);
		}
		// 关闭通道
		channel.close();
		// 关闭连接
		conn.close();
	}
}
