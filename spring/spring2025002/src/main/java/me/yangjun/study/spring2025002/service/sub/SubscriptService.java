package me.yangjun.study.spring2025002.service.sub;

public interface SubscriptService {
    String getTopic();

    /**
     * 处理消息
     * 方法名是MessageListenerAdapter#ORIGINAL_DEFAULT_LISTENER_METHOD，这样装饰器不指定默认方法就能找到这个方法
     *
     * @param message 信息
     */
    void handleMessage(String message);
}
