package com.harrisonphung.Notifier.config;

/**
 * Created by harrisonphung on 11/17/18.
 */

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfig {

    @Autowired
    TwilioConfiguration twilioConfiguration;

    @PostConstruct
    public void initTwilio(){
        Twilio.init(twilioConfiguration.getSid(), twilioConfiguration.getAuthToken());
    }
}
