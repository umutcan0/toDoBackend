package com.example.todobackend.requests;

import com.example.todobackend.entity.ItemList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ItemListUpdateRequest {
    @NotBlank(message = "{itemlistupdaterequest.listname.blank}")
    @Size(min = 3, max = 20, message = "{itemlistupdaterequest.listname.length}")
    private String listName;

    private Long id;

    public ItemListUpdateRequest() {

    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}