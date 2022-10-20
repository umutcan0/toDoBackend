package com.example.todobackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
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

}