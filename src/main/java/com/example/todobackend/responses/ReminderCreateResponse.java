package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;

public class ReminderCreateResponse {

    private Long reminderId;

    @InfoLogger(value = "ItemList olusturuldu", showData = true)
    private String message;

    public ReminderCreateResponse(String message, Long reminderId) {
        this.message = message;
        this.reminderId = reminderId;
    }

    public ReminderCreateResponse() {

    }
}
