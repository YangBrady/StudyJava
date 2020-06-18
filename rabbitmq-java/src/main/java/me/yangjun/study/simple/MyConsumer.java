package me.yangjun.study.simple;

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
public class MyConsumer {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";
    private final static String ROUTING_KEY = "SIMPLE_ROUTING_KEY";

    public static void main(String[] args) throws Exception {

        Channel channel = ConnectionUtil.getChannel(QUEUE_NAME, "direct", EXCHANGE_NAME, ROUTING_KEY);
        log.info(" Waiting for message....");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) {
                String msg = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag);
                System.out.println("deliveryTag : " + envelope.getDeliveryTag());
            }
        };

        // 开始获取消息
        // String queue, boolean autoAck, Consumer callback
        // autoAck 消息应答
        // 默认轮询分发打开：true ：这种模式一旦rabbitmq将消息发送给消费者，就会从内存中删除该消息，不关心客户端是否消费正常。
        // 使用公平分发需要关闭autoAck:false  需要手动发送回执
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
