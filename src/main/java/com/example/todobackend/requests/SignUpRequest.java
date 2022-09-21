package com.example.todobackend.requests;

import com.example.todobackend.validation.EmailExists;
import com.example.todobackend.validation.UsernameExists;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MulticastMessage;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

public class SignUpRequest {


    @NotBlank(message = "{singuprequest.name.blank}")
    @Size(min = 3, max = 20, message = "{singuprequest.name.length}")
    private String name;

    @NotBlank(message = "{singuprequest.surname.blank}")
    @Size(min = 3, max = 20, message = "{singuprequest.surname.length}")
    private String surname;

    //@UniqueInDB(reposıtory vs vs = "", column= "")
    @UsernameExists(message = "{singuprequest.username.exist}") //my annotation
    @NotBlank(message = "{singuprequest.username.blank}")
    @Size(min = 3, max = 20, message = "{singuprequest.username.length}")
    private String username;

    //@UniqueInDB(table = "", column= "")
    @EmailExists(message = "{singuprequest.email.exist}") //my annotation
    @Email(message = "{singuprequest.email.control}")
    private String email;

    @NotBlank(message = "{singuprequest.password.blank}")
    @Size(min = 3, max = 20)
    private String password;


    private String fcm_token;

    public SignUpRequest() {
    }

    public SignUpRequest(String name, String surname, String username, String email, String password) {

        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFcm_token(String fcm_token) {this.fcm_token = fcm_token;}

    public String getFcm_token() {return fcm_token;}
}
