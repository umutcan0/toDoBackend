package com.example.todobackend.exception;

public class ItemWithNameNotFoundException extends ResourceNotFoundException { // Exception.getMessage()

    public ItemWithNameNotFoundException(String name) {
        super("itemwithnamenotfoundexception", new Object[] {name});
    }
}