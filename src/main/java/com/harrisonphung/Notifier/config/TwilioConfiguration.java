package com.harrisonphung.Notifier.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by harrisonphung on 11/17/18.
 */

@Configuration
@ConfigurationProperties(prefix = "twilio.account")
public class TwilioConfiguration {

    private String sid;
    private String authToken;
    private String fromNumber;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }
}
