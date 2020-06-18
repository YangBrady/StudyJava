package me.yangjun.study.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 生产者
 * 没有绑定队列和交换机，消息将丢失，因为，交换机没有存储消息的能力
 *
 * @author mooejun
 * @since 2020/6/18 12:13 上午
 */
public class MyProducer {

	private final static String EXCHANGE_NAME = "TOPIC_EXCHANGE";
	private final static String EXCHANGE_TYPE = "topic";

	public static void main(String[] args) throws Exception {

		// 建立连接
		Connection conn = ConnectionUtil.getConnection();
		// 创建消息通道
		Channel channel = conn.createChannel();

		// 声明交换机（已经存在的话就不会再创建）
		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE,
				false, false, null);

		// 发送消息
		String msgAdd = "Hello world!, 你好，Rabbit MQ";
		channel.basicPublish(EXCHANGE_NAME, "AA", null, "AA".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "AA.123", null, "AA.123".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "BB.123", null, "BB.123".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "BB.123.4", null, "BB.1234".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "CC", null, "CC".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "a.CC", null, "a.CC".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "a.b.CC", null, "a.b.CC".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "AA.CC", null, "AA.CC".getBytes());
		channel.basicPublish(EXCHANGE_NAME, "AA.BB.CC", null, "AA.BB.CC".getBytes());

		channel.close();
		conn.close();
	}
}