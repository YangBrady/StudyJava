package me.yangjun.study.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.nio.charset.StandardCharsets;

@Slf4j
public class FourthConsumer implements MessageListener {

	public void onMessage(Message message) {
		String msg = new String(message.getBody(), StandardCharsets.UTF_8);
		log.info("The Consumer4 received message: {}", msg);
	}
}

