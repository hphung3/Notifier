package com.harrisonphung.Notifier.controller;

import com.harrisonphung.Notifier.config.TwilioConfiguration;
import com.harrisonphung.Notifier.exception.NumberNotFoundException;
import com.harrisonphung.Notifier.message.MessagePacket;
import com.harrisonphung.Notifier.message.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by harrisonphung on 7/31/18.
 */
@Controller
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

    @RequestMapping(value="/users/{id}")
    public ResponseEntity testReqParam(@PathVariable(value="id") String id){
        System.out.println(id);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }

    @RequestMapping("/numbers")
    public @ResponseBody String numbers() {
        throw new NumberNotFoundException();
//        return "1";
    }
}
