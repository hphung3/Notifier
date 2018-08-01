package com.harrisonphung.Notifier.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by harrisonphung on 7/29/18.
 */
public class MessagePacket {

    @JsonProperty("phoneNumber")
    private String toNumber;
    @JsonProperty("message")
    private String message;

    public MessagePacket(){

    }

    public MessagePacket(String toNumber, String message) {
        this.toNumber = toNumber;
        this.message = message;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
