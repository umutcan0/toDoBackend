package com.example.todobackend.entity;


import com.example.todobackend.log.InfoLogger;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reminder_cantodo")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "date")
    private Date date; // 30 haziran 2022 14:30

    @InfoLogger(value="Reminder id", showData = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "item_id") //
    private Item item; // item_id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "token_id")
    private Token token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Token getToken() {return token;}

    public void setToken(Token token) {this.token = token;}
}
