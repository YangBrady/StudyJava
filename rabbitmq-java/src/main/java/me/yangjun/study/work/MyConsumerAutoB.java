package me.yangjun.study.work;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * 消费者
 *
 * @author mooejun
 * @since 2020/6/17 9:38 下午
 */

@Slf4j
public class MyConsumerAutoB {
    private final static String EXCHANGE_NAME = "WORK_EXCHANGE";
    private final static String EXCHANGE_TYPE = "direct";
    private final static String QUEUE_NAME = "WORK_QUEUE";
    private final static String ROUTING_KEY = "WORK_ROUTING_KEY";

    public static void main(String[] args) throws Exception {
        // 建立连接
        Connection conn = ConnectionUtil.getConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 声明交换机（已经存在的话就不会再创建）
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, false, false, null);

        // 声明队列（已经存在的话就不会再创建）
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        log.info(" Waiting for message....");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            int i = 0;

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) {
                String msg = new String(body, StandardCharsets.UTF_8);
                i++;
                log.info("MyConsumerAutoB Received {}, message: {}, consumerTag: {}, deliveryTag: {}",
                        i, msg, consumerTag, envelope.getDeliveryTag());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 开始获取消息
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
