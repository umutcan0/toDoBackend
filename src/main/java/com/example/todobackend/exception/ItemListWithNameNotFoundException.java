package com.example.todobackend.exception;

public class ItemListWithNameNotFoundException extends ResourceNotFoundException {

    public ItemListWithNameNotFoundException(String name) {
        super("itemlistwithnamenotfoundexception ", new Object[]{name});
    }
}
