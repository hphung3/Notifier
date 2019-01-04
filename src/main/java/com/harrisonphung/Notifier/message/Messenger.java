package com.harrisonphung.Notifier.message;

import com.harrisonphung.Notifier.config.TwilioConfiguration;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by harrisonphung on 7/29/18.
 */
public class Messenger {

    TwilioConfiguration twilioConfiguration;

    public Messenger(TwilioConfiguration twilioConfiguration){
        this.twilioConfiguration = twilioConfiguration;
    }

    public void sendMessage(MessagePacket messagePacket){
    com.twilio.rest.api.v2010.account.Message.creator(
                new com.twilio.type.PhoneNumber(messagePacket.getToNumber()),
                new com.twilio.type.PhoneNumber(twilioConfiguration.getFromNumber()),
                messagePacket.getMessage())
                .create();
    }

}
