package me.yangjun.study.pubsub;

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

    final static String EXCHANGE_NAME = "PUBSUB_EXCHANGE";
    final static String EXCHANGE_TYPE = "fanout";
    final static String ROUTING_KEY = "";

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

    static Channel getChannel() throws Exception {
        // 建立连接
        Connection conn = getConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 声明交换机（已经存在的话就不会再创建）
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE, false, false, null);

        return channel;
    }
}
