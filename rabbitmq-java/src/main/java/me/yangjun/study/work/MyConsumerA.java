package me.yangjun.study.work;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author mooejun
 * @since 2020/6/18 10:22 上午
 */
@Slf4j
public class MyConsumerA {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";
    private final static String ROUTING_KEY = "SIMPLE_ROUTING_KEY";

    public static void main(String[] args) throws Exception {

        Channel channel = ConnectionUtil.getChannel(QUEUE_NAME, "direct", EXCHANGE_NAME, ROUTING_KEY);
        log.info(" Waiting for message....");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            int i = 0;

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, StandardCharsets.UTF_8);
                i++;
                log.info("MyConsumerAutoA Received {}, message: {}, consumerTag: {}, deliveryTag: {}",
                        i, msg, consumerTag, envelope.getDeliveryTag());
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
