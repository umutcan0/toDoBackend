package com.example.todobackend.exception;

public class ReminderWithIdNotFoundException extends ResourceNotFoundException {


    public ReminderWithIdNotFoundException(Long id) {
        super("reminderwithidnotfoundexception", new Object[] {id.toString()});
        // id.toString()) par ekleametere
    }
}
//log back