package com.example.todobackend.exception;

public class UserWithEmailExistsException extends BadRequestException{
    public UserWithEmailExistsException(String name) {
        super("userwithemailexistsexception", new Object[]{name});
    }
}
