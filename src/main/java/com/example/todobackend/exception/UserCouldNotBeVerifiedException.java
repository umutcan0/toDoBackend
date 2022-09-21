package com.example.todobackend.exception;

public class UserCouldNotBeVerifiedException extends BadRequestException{
    public UserCouldNotBeVerifiedException(Long id) {
        super("usercouldnotbeverifiedexception",new Object[] {id.toString()});
    }
}