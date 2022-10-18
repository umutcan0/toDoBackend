package com.example.todobackend.responses;

import com.example.todobackend.log.InfoLogger;

public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    @InfoLogger(value="Kullanici adi", showData = true)
    private String username;
    @InfoLogger(value="Kullanici e postasi")
    private String email;


    public LoginResponse(String accessToken, Long id, String username, String email) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;

    }
    public LoginResponse() {

    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
