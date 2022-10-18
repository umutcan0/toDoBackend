package com.example.todobackend.advice;

import com.example.todobackend.exception.ResourceNotFoundException;
import com.example.todobackend.log.ErrorLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class ResourceNotFoundAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ErrorLogger(value = "Resource not found")
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity resourceNotFoundException(ResourceNotFoundException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }
}