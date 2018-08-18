package com.harrisonphung.Notifier.controller;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.harrisonphung.Notifier.message.Messenger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by harrisonphung on 7/31/18.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class MessageControllerTest {

    @Autowired
    @InjectMocks
    MessageController messageController;

    @Mock
    Messenger messengerMock;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @Ignore("this will send a text message.. not sure why mock isn't getting called")
    public void consumeMessageThroughEndpoint() {
        doNothing().when(messengerMock).sendMessage(any());
        URL url = Resources.getResource("TextMessagePayload.json");
        String text = null;
        try {
            text = Resources.toString(url, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity(text, requestHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("http://localhost:" + port + "/messages", httpEntity, String.class);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Message Sent!",responseEntity.getBody());
    }

}