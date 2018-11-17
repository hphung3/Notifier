package com.harrisonphung.Notifier.amqp;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by harrisonphung on 8/1/18.
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message){
        System.out.println("Received <" + message + ">");
        String test = new String(message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
