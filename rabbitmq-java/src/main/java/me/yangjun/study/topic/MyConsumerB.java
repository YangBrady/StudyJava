package me.yangjun.study.topic;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author mooejun
 * @since 2020/6/18 3:19 下午
 */
@Slf4j
public class MyConsumerB {

	private final static String EXCHANGE_NAME = "TOPIC_EXCHANGE";
	private final static String EXCHANGE_TYPE = "topic";
	private final static String QUEUE_NAME = "Topic_QueueName_B";

	public static void main(String[] args) throws Exception {

		// 建立连接
		Connection conn = ConnectionUtil.getConnection();
		// 创建消息通道
		Channel channel = conn.createChannel();

		// 声明交换机（已经存在的话就不会再创建）
		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, false, false, null);

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换机
		// 支持路由键以 BB 开头的消息路由，并且后面是一个单词的消息路由
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "BB.*");

		// 同一时刻服务器只会发一条消息给消费者
		channel.basicQos(1);
		log.info(" Waiting for message....");

		// 创建消费者
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
			                           byte[] body) throws IOException {
				String msg = new String(body, StandardCharsets.UTF_8);
				log.info("MyConsumerB Received , message: {}, consumerTag: {}, deliveryTag: {}",
						msg, consumerTag, envelope.getDeliveryTag());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// 返回确认状态
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};

		// 开始获取消息
		channel.basicConsume(QUEUE_NAME, false, consumer);
	}
}
