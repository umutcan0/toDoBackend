package com.example.todobackend.requests;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.ItemList;
import com.example.todobackend.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ItemCreateRequest {

    @NotBlank(message = "{itemcreaterequest.name.blank}")
    @Size(min = 3, max = 20, message = "{itemcreaterequest.name.length}")
    private String name;

    @NotBlank(message = "{itemcreaterequest.description.blank}")
    @Size(min = 3, max = 400, message = "{itemcreaterequest.description.length}")
    private String description;

    private Long itemList_id;


    public ItemCreateRequest() {

    }

    public Item createItem(User user, ItemList itemList) {
        Item item = new Item();
        item.setName(this.name);
        item.setDescription(this.description);
        return item;
    }
}
