package com.example.todobackend.validation;

import com.example.todobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateUsername implements ConstraintValidator<UsernameExists, String> {
    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean isValid(String username, ConstraintValidatorContext cxt){
        return !userRepository.findByEmail(username).isPresent();
    }
}
