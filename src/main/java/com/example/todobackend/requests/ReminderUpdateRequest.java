package com.example.todobackend.requests;

import com.example.todobackend.validation.DateIsAfter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class ReminderUpdateRequest {

    @DateIsAfter
    private Date date;

    private Long id;


    public ReminderUpdateRequest(){

    }

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
