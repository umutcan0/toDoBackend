package com.example.todobackend.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name = "crud_cantodo")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "checked", columnDefinition = "boolean default false")
    private Boolean checked = false;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // @ManyToOne(name = "item_id")
    private Set<Reminder> reminders; // key : value // json => bson

    @ManyToOne
    @JoinTable(name = "itemList_id") //
    private ItemList itemList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item setChecked() {
        this.checked = !this.checked;
        return this;
    }
    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }
}