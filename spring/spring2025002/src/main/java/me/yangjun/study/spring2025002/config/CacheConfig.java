package me.yangjun.study.spring2025002.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import me.yangjun.study.spring2025002.constants.TopicConstants;
import me.yangjun.study.spring2025002.service.sub.impl.SubscriptServiceAImpl;
import me.yangjun.study.spring2025002.service.sub.impl.SubscriptServiceBImpl;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    // TODO 嘘要根据不同业务逻辑拆分？
    @Bean
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterWrite(Duration.ofMinutes(10))
                .build();
    }

    /**
     * redis 读取内容的template
     */
    @Bean
    public StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    public RedisMessageListenerContainer container(LettuceConnectionFactory connectionFactory,
                                                   // 这里可以指定多个MessageListenerAdapter，MessageListenerAdapter名字要与下面定义的bean的方法名字一致，否则会注入不进来
                                                   MessageListenerAdapter listenerAdapter1,
                                                   MessageListenerAdapter listenerAdapter2) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 这里将channel的订阅者添加到container中，并指定要消费的channel
        container.addMessageListener(listenerAdapter1, new PatternTopic(TopicConstants.TEST_TOPIC));
        container.addMessageListener(listenerAdapter2, new PatternTopic(TopicConstants.TEST_TOPIC));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter1(SubscriptServiceAImpl sub) {
        return new MessageListenerAdapter(sub, "subscript");
    }

    @Bean
    public MessageListenerAdapter listenerAdapter2(SubscriptServiceBImpl sub) {
        return new MessageListenerAdapter(sub, "subscript");
    }
}