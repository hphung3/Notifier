package com.harrisonphung.Notifier.controller;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.harrisonphung.Notifier.message.Messenger;
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
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

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
    TestRestTemplate restTemplate;

    @Test
    public void consumeMessageThroughEndpoint() {
        Mockito.doNothing().when(messengerMock).sendMessage(Mockito.any());
        URL url = Resources.getResource("TextMessagePayload.json");
        String text = null;
        try {
            text = Resources.toString(url, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(text, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/messages", httpEntity, String.class);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Message Sent!",responseEntity.getBody());
    }

}