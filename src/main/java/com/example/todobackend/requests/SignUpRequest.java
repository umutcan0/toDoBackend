package com.example.todobackend.requests;

import com.example.todobackend.validation.EmailExists;
import com.example.todobackend.validation.UsernameExists;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {


    @NotBlank(message = "{signuprequest.name.blank}")
    @Size(min = 3, max = 20, message = "{signuprequest.name.length}")
    private String name;

    @NotBlank(message = "{signuprequest.surname.blank}")
    @Size(min = 3, max = 20, message = "{signuprequest.surname.length}")
    private String surname;

    //@UniqueInDB(reposıtory vs vs = "", column= "")
    @UsernameExists(message = "{signuprequest.username.exist}") //my annotation
    @NotBlank(message = "{signuprequest.username.blank}")
    @Size(min = 3, max = 20, message = "{signuprequest.username.length}")
    private String username;

    //@UniqueInDB(table = "", column= "")
    @EmailExists(message = "{signuprequest.email.exist}") //my annotation
    @Email(message = "{signuprequest.email.control}")
    private String email;

    @NotBlank(message = "{signuprequest.password.blank}")
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

}
