package com.harrisonphung.Notifier.message;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by harrisonphung on 7/29/18.
 */
@Component
public class Messenger {

    @Value("${twilio.account.sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.account.auth_token}")
    private String AUTH_TOKEN;

    @Value("${twilio.account.from_number}")
    private String fromNumber;

    @PostConstruct
    public void initTwilio(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    private Messenger(){
    }

    public void sendMessage(MessagePacket messagePacket){
    com.twilio.rest.api.v2010.account.Message.creator(
                new com.twilio.type.PhoneNumber(messagePacket.getToNumber()),
                new com.twilio.type.PhoneNumber(fromNumber),
                messagePacket.getMessage())
                .create();
    }

}
