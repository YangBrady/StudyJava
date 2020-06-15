package me.yangjun.study.event.synch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author mooejun
 * @since 2020/04/27 11:25
 */
@Slf4j
@Component
public class CustomEventPublisher {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void doPublish(String message) {
		log.info("publish start");
		CustomEvent customEvent = new CustomEvent(this, message);
		publisher.publishEvent(customEvent);
		log.info("publish end");
	}
}
