package me.yangjun.study.routing;

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

    public static void main(String[] args) throws Exception {

        // 建立连接
        Connection conn = ConnectionUtil.getConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 声明交换机（已经存在的话就不会再创建）
        channel.exchangeDeclare(ConnectionUtil.EXCHANGE_NAME, ConnectionUtil.EXCHANGE_TYPE,
                false, false, null);

        // 发送消息
        String msgAdd = "新增";
        String msgDelete = "删除";
        String msgModify = "修改";
        String msgQuery = "查询";
        for (int i = 0; i < 3; i++) {
            channel.basicPublish(ConnectionUtil.EXCHANGE_NAME, "add", null, msgAdd.getBytes());
            channel.basicPublish(ConnectionUtil.EXCHANGE_NAME, "delete", null, msgDelete.getBytes());
            channel.basicPublish(ConnectionUtil.EXCHANGE_NAME, "modify", null, msgModify.getBytes());
            channel.basicPublish(ConnectionUtil.EXCHANGE_NAME, "query", null, msgQuery.getBytes());
        }

        channel.close();
        conn.close();
    }
}