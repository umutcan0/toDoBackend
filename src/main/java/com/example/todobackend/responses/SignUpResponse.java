package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;

public class SignUpResponse {
    @InfoLogger(value="Mesaj", showData = true)
    private String message;

    public SignUpResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
