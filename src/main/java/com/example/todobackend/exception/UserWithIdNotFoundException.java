package com.example.todobackend.exception;

public class UserWithIdNotFoundException extends ResourceNotFoundException {

    public UserWithIdNotFoundException(Long id) {
        super("userwithidnotfoundexception", new Object[]{id.toString()});
    }
}
