package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;

public class ItemListCreateResponse {
    private Long itemListId;

    @InfoLogger(value = "ItemList olusturuldu", showData = true)
    private String message;

    public ItemListCreateResponse(String message, Long itemListId) {
        this.message = message;
        this.itemListId = itemListId;
    }

    public ItemListCreateResponse() {

    }
}
