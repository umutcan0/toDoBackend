package com.example.todobackend.requests;

import com.example.todobackend.entity.ItemList;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ItemListCreateRequest {
    @NotBlank(message = "{itemlistcreaterequest.listName.blank}")
    @Size(min = 3, max = 20, message = "{itemlistcreaterequest.listName.length}")
    private String listName;

    public ItemListCreateRequest() {

    }

    public ItemList getAsItemList() {
        ItemList itemList = new ItemList();
        itemList.setListName(this.listName);
        return itemList;
    }
}
