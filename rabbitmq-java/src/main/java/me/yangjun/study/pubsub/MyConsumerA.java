package me.yangjun.study.pubsub;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 消费者
 *
 * @author mooejun
 * @since 2020/6/17 9:38 下午
 */
@Slf4j
public class MyConsumerA {

    private final static String QUEUE_NAME = "PubSub_QueueName_A";

    public static void main(String[] args) throws Exception {

        Channel channel = ConnectionUtil.getChannel();
        log.info(" Waiting for message....");

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, ConnectionUtil.EXCHANGE_NAME, "");
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, StandardCharsets.UTF_8);
                log.info("MyConsumerA Received , message: {}, consumerTag: {}, deliveryTag: {}",
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
