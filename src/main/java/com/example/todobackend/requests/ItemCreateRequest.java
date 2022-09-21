package com.example.todobackend.requests;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.ItemList;
import com.example.todobackend.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemList_id() {return itemList_id;}

    public void setItemList_id(Long itemList_id) {this.itemList_id = itemList_id;}

    /*   public Long getItemList_id() {
        return itemList_id;
    }

    public void setItemList_id(Long itemList_id) {
        this.itemList_id = itemList_id;
    }

    public Long getReminder_id() {return reminder_id;}

    public void setReminder_id(Long reminder_id) {this.reminder_id = reminder_id;}*/
}
