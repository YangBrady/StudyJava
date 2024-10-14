package com.example.javaother.disruptor.test;

import com.example.javaother.disruptor.event.BradyEvent;
import com.example.javaother.disruptor.event.BradyEventFactory;
import com.example.javaother.disruptor.handler.BradyEventHandler;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DisruptorDemo {
    public static void main(String[] args) throws InterruptedException {
        Disruptor<BradyEvent> disruptor = getBradyEventDisruptor();

        for (int i = 0; true; i++) {
            RingBuffer<BradyEvent> ringBuffer = disruptor.getRingBuffer();
            long next = ringBuffer.next();
            try {
                BradyEvent event = ringBuffer.get(next);
                event.setEventMsg(i + "");
            } finally {
                ringBuffer.publish(next);
            }
            TimeUnit.SECONDS.sleep(3);
        }
    }

    private static Disruptor<BradyEvent> getBradyEventDisruptor() {
        BradyEventFactory eventFactory = new BradyEventFactory();
        int ringBufferSize = 16;
        ThreadFactory threadFactory = r -> new Thread(r, "simpleThread");
        BlockingWaitStrategy waitStrategy = new BlockingWaitStrategy();

        Disruptor<BradyEvent> disruptor =
            new Disruptor<>(eventFactory, ringBufferSize, threadFactory, ProducerType.SINGLE, waitStrategy);

        BradyEventHandler eventHandler = new BradyEventHandler();
        disruptor.handleEventsWith(eventHandler);
        disruptor.start();
        return disruptor;
    }
}
