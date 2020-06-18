package me.yangjun.study.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import me.yangjun.study.utils.ConnectionUtil;

/**
 * 生产者
 *
 * @author mooejun
 * @since 2020/6/18 12:13 上午
 */
public class MyProducer {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String ROUTING_KEY = "SIMPLE_ROUTING_KEY";

    public static void main(String[] args) throws Exception {

        // 建立连接
        Connection conn = ConnectionUtil.getConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 发送消息
        String msg = "Hello world!, 你好，Rabbit MQ";
        // String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, msg.getBytes());
        channel.close();
        conn.close();
    }
}