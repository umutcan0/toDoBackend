package com.example.todobackend.exception;

public class PasswordsDoNotMatchException extends BadRequestException {

    public PasswordsDoNotMatchException(String username) {
        super("passwordsdonotmatchexception ", new Object[]{username});
    }
}