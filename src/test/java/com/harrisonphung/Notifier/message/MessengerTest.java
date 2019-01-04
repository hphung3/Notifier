package com.harrisonphung.Notifier.message;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by harrisonphung on 7/29/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MessengerTest {

    @Autowired
    Messenger messenger;

    @Test
    @Ignore("This is a test to twilio API")
    public void sendMessage() throws Exception {
        MessagePacket messagePacket = new MessagePacket("6786546266", "This is a TEST for me");
        messenger.sendMessage(messagePacket);
    }



}