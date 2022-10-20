package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;

public class ReminderUpdateResponse {

    private Long reminderId;

    @InfoLogger(value = "ItemList olusturuldu", showData = true)
    private String message;

    public ReminderUpdateResponse(String message, Long reminderId) {
        this.message = message;
        this.reminderId = reminderId;
    }

    public ReminderUpdateResponse() {

    }
}
