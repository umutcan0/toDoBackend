/*
package com.example.todobackend.advice;

import com.example.todobackend.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;


@ControllerAdvice
public class UserAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseBody
    @ExceptionHandler({ItemListWithIdNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity itemListWithIdNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }
    */
/*String itemListNotFoundHandler(ItemListWithIdNotFoundException e) {
        return messageSource.getMessage(e.getMessage({message = "{loginrequest.username.blank}"});  //e.getMessage() e.params lang}*//*


    @ResponseBody
    @ExceptionHandler(ItemWithIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity itemWithIdNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler({ItemListWithNameNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity itemListWithNameNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(ItemWithNameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity itemWithNameNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(PasswordsDoNotMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity passwordsDoNotMatchException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(ReminderWithIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity reminderWithIdNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(UserCouldNotBeVerifiedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity userCouldNotBeVerifiedException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }


    @ResponseBody
    @ExceptionHandler(UserWithEmailExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity userWithEmailExistsException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(UserWithIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity userWithIdNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(UserWithNameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity userWithNameNotFoundException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }

    @ResponseBody
    @ExceptionHandler(UserWithUsernameExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity userWithUsernameExistsException(BadRequestException exception, Locale locale) {

        String messageName = exception.getMessageName();
        Object[] args = exception.getArgs();

        String message = messageSource.getMessage(messageName, args, locale);
        return ResponseEntity.badRequest().body(message);
    }
}
*/
