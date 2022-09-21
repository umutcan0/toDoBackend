package com.example.todobackend.validation;

import com.example.todobackend.entity.User;
import com.example.todobackend.exception.UserWithEmailExistsException;
import com.example.todobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidateEmail implements ConstraintValidator<EmailExists, String> {
    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt){
        Boolean exists = userRepository.findByEmail(email).isPresent();
        return !exists;
    }
}
