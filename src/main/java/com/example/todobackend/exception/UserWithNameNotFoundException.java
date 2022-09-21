package com.example.todobackend.exception;

public class UserWithNameNotFoundException extends ResourceNotFoundException{

    public UserWithNameNotFoundException(String name) {
            super("userwithnamenotfoundexception", new Object[]{name});
    }

}
