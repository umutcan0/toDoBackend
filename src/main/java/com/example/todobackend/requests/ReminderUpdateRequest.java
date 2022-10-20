package com.example.todobackend.requests;

import com.example.todobackend.validation.DateIsAfter;
import lombok.Data;

import java.util.Date;

@Data
public class ReminderUpdateRequest {

    @DateIsAfter
    private Date date;

    private Long id;


    public ReminderUpdateRequest() {

    }

}
