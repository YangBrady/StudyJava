package com.example.javaother.disruptor.handler;

import com.example.javaother.disruptor.event.BradyEvent;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BradyEventHandler implements EventHandler<BradyEvent> {
    @Override
    public void onEvent(BradyEvent bradyEvent, long sequence, boolean endOfBatch) throws Exception {
        log.info("on event: event={}, sequence={}, endOfBatch={}", bradyEvent, sequence, endOfBatch);
    }
}
