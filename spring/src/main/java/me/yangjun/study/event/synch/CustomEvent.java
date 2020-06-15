package me.yangjun.study.event.synch;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author mooejun
 * @since 2020/04/27 11:22
 */

public class CustomEvent extends ApplicationEvent {

	@Getter
	private String eventMessage;

	public CustomEvent(Object source, String eventMessage) {
		super(source);
		this.eventMessage = eventMessage;
	}

}