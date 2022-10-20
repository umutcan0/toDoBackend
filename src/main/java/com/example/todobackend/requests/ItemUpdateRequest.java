package com.example.todobackend.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ItemUpdateRequest {

    @NotBlank(message = "{itemupdaterequest.item.blank}")
    @Size(min = 3, max = 20, message = "{itemupdaterequest.item.length}")
    private String name;

    private Long id;

    public ItemUpdateRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
