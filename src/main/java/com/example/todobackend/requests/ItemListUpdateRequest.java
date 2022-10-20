package com.example.todobackend.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ItemListUpdateRequest {
    @NotBlank(message = "{itemlistupdaterequest.listname.blank}")
    @Size(min = 3, max = 20, message = "{itemlistupdaterequest.listname.length}")
    private String listName;

    private Long id;

    public ItemListUpdateRequest() {

    }

}