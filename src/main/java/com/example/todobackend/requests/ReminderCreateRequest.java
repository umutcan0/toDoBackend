package com.example.todobackend.requests;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.Reminder;
import com.example.todobackend.entity.Token;
import com.example.todobackend.validation.DateIsAfter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class ReminderCreateRequest {

    // DateAfter diye bir anotasyon acabilirsin, bu anotasyon direkt alttaki date'i alir su anki saatle compare eder
    // Java date compare
    @Future //my annotation
    private Date date;

    private Long item_id;

    public ReminderCreateRequest(){

    }

    public Reminder createReminder(Token token, Item item){
        Reminder reminder=new Reminder();
        reminder.setDate(this.date);
        reminder.setItem(item); // date , item
        reminder.setToken(token);
        return reminder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getItem_id() {return item_id;}
}
