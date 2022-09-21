package com.example.todobackend.exception;

public class UserWithUsernameExistsException extends BadRequestException {
    public UserWithUsernameExistsException(String username) {
        super("userwithusernameexistsexception ", new Object[]{username});
    }
}
