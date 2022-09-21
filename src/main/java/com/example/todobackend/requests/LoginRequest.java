package com.example.todobackend.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "{loginrequest.username.blank}")
    @Size(min = 3, max = 20, message = "{loginrequest.username.length}")
    private String username;

    @NotBlank(message = "{loginrequest.password.blank}")
    @Size(min = 3, max = 200, message = "{loginrequest.password.length}")
    private String password;

    private String fcm_token;

    public LoginRequest(){

    }

    public LoginRequest(String username, String password, String fcm_token) {

        this.username = username;
        this.password = password;
        this.fcm_token = fcm_token;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFcm_token() {return fcm_token;}

    public void setFcm_token(String fcm_token) {this.fcm_token = fcm_token;}
}
