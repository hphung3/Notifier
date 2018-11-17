package com.harrisonphung.Notifier.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by harrisonphung on 9/4/18.
 */
@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver){
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Sending Message");
        rabbitTemplate.convertAndSend(MessageListenerConfig.topicExchangeName, "foo.bar.haz", "HELLO");
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }
}
