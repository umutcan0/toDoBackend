package com.example.todobackend.validation;

import com.example.todobackend.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class ValidateDateIsAfter implements ConstraintValidator<DateIsAfter, Date> {
    @Autowired
    private ReminderRepository reminderRepository;


    @Override
    public boolean isValid(Date date, ConstraintValidatorContext cxt){
        Date currentDate=new Date();
        return currentDate.after(date);
    }
}