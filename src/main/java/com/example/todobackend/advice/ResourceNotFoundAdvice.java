package com.example.todobackend.advice;

import com.example.todobackend.exception.BadRequestException;
import com.example.todobackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

public class ResourceNotFoundAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity resourceNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }
}
