package com.example.todobackend.exception;


public class ItemListWithIdNotFoundException extends ResourceNotFoundException{
    public ItemListWithIdNotFoundException(Long id) {
        super("itemlistwithidnotfoundexception", new Object[]{id.toString()});
    }
}
