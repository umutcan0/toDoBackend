package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;
import lombok.Data;

@Data
public class ItemCreateResponse {
    private Long itemId;

    @InfoLogger(value = "Item olusturuldu", showData = true)
    private String message;

    public ItemCreateResponse(String message, Long itemId) {
        this.message = message;
        this.itemId = itemId;
    }

    public ItemCreateResponse() {

    }
}
