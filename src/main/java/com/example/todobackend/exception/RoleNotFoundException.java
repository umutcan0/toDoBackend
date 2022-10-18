package com.example.todobackend.exception;

public class RoleNotFoundException extends ResourceNotFoundException {

    public RoleNotFoundException(String name) {
        super("rolenotfoundexception", new Object[]{name});
    }

}
