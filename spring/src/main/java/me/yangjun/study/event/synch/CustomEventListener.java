package me.yangjun.study.event.synch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author mooejun
 * @since 2020/04/27 11:29
 */
@Slf4j
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info("event listener - {}", event.getEventMessage());
    }
}
