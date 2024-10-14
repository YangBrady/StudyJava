package com.example.javaother.disruptor.test;

import com.example.javaother.disruptor.event.BradyEvent;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
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
        EventFactory<BradyEvent> eventFactory = BradyEvent::new;
        int ringBufferSize = 16;
        ThreadFactory threadFactory = r -> new Thread(r, "simpleThread");
        ProducerType producerType = ProducerType.SINGLE;
        BlockingWaitStrategy waitStrategy = new BlockingWaitStrategy();

        Disruptor<BradyEvent> disruptor =
            new Disruptor<>(eventFactory, ringBufferSize, threadFactory, producerType, waitStrategy);

        EventHandler<BradyEvent> eventHandler =
            (event, sequence, endOfBatch) -> System.out.println("on event: event" + event);
        disruptor.handleEventsWith(eventHandler);
        disruptor.start();
        return disruptor;
    }
}
