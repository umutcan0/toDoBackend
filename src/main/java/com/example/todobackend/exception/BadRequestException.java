package com.example.todobackend.exception;

public class BadRequestException extends RuntimeException{

    private final Object[] args;

    private final String messageName;

    public BadRequestException(String messageName, Object[] args){
        super(messageName);
        this.messageName = messageName;
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getMessageName() {
        return messageName;
    }
}
