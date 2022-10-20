package com.example.todobackend.exception;

public class ItemWithIdNotFoundException extends ResourceNotFoundException {

    public ItemWithIdNotFoundException(Long id) {
        super("itemwithidnotfoundexception", new Object[]{id.toString()});
    }
}
