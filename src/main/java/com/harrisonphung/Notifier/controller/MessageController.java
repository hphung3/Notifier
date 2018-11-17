package com.harrisonphung.Notifier.controller;

import com.harrisonphung.Notifier.config.TwilioConfiguration;
import com.harrisonphung.Notifier.message.MessagePacket;
import com.harrisonphung.Notifier.message.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by harrisonphung on 7/31/18.
 */
@Controller
@RequestMapping("api")
public class MessageController {

    @Autowired
    Messenger messenger;

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseEntity sendMessageToReceipient(@RequestBody MessagePacket messagePacket){
        messenger.sendMessage(messagePacket);
        return new ResponseEntity<String>("Message Sent!", HttpStatus.OK);
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResponseEntity esfasfasf(){
        return new ResponseEntity<String>("TEST Sent!", HttpStatus.OK);
    }
}
