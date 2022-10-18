package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;

public class ItemListUpdateResponse {

    private Long itemListId;

    @InfoLogger(value="ItemList guncellendi", showData = true)
    private String message;

    public ItemListUpdateResponse(String message, Long itemListId) {
        this.message = message;
        this.itemListId=itemListId;
    }

    public ItemListUpdateResponse() {

    }
}


/// item listin ismini girdi
// itemlisti idsi append ediyorsun
//