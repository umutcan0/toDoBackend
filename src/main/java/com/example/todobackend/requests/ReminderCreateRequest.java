package com.example.todobackend.requests;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.Reminder;
import com.example.todobackend.entity.Token;
import lombok.Data;

import javax.validation.constraints.Future;
import java.util.Date;

@Data
public class ReminderCreateRequest {

    // DateAfter diye bir anotasyon acabilirsin, bu anotasyon direkt alttaki date'yi alir su anki saatle compare eder
    // Java date compare
    @Future //my annotation
    private Date date;

    private Long item_id;

    public ReminderCreateRequest() {

    }

    public Reminder createReminder(Token token, Item item) {
        Reminder reminder = new Reminder();
        reminder.setDate(this.date);
        reminder.setItem(item); // date , item
        reminder.setToken(token);
        return reminder;
    }

}
