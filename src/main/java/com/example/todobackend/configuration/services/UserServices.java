package com.example.todobackend.configuration.services;

import com.example.todobackend.configuration.jwt.AuthEntryPointJwt;
import com.example.todobackend.entity.User;
import com.example.todobackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServices {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    public void register(User user, String siteURL) {
    }

    private void sendVerificationEmail(User user, String siteURL) {
    }

    public UserRepository getRepo() {
        return repo;
    }

    public void setRepo(UserRepository repo) {
        this.repo = repo;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
