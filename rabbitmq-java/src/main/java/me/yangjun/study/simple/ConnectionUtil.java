package me.yangjun.study.simple;

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
    private final static String RBAATIEMQ_IP = "192.168.3.49";
    private final static int RBAATIEMQ_PORT = 5672;
    private final static String VIRTUAL_HOST = "VHost_StudyJava";
    private final static String RBAATIEMQ_USER = "mqroot";
    private final static String RBAATIEMQ_PASSWORD = "mqroot";

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";
    private final static String ROUTING_KEY = "SIMPLE_ROUTING_KEY";

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

    static Channel getChannel(String queueName, String exchangeName, String exchangeType, String routingKey)
            throws Exception {
        // 建立连接
        Connection conn = getConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 声明交换机（已经存在的话就不会再创建）
        // String exchange, String type, boolean durable, boolean autoDelete, Map<String, Object> arguments
        channel.exchangeDeclare(exchangeName, exchangeType, false, false, null);

        // 声明队列（已经存在的话就不会再创建）
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(queueName, false, false, false, null);

        // 绑定队列和交换机
        channel.queueBind(queueName, exchangeName, routingKey);

        return channel;
    }
}
