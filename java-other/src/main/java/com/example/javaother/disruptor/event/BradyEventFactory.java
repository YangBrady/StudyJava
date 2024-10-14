package com.example.javaother.disruptor.event;

import com.lmax.disruptor.EventFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BradyEventFactory implements EventFactory<BradyEvent> {
    @Override
    public BradyEvent newInstance() {
        return new BradyEvent("haha Brady");
    }
}
