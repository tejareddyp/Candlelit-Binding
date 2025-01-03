package com.casestudy.webapp.form;


import com.casestudy.webapp.validation.EmailUnique;
import com.casestudy.webapp.validation.UsernameUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpFormBean {

    @EmailUnique(message = "Email already exists")
    @NotEmpty(message = "Email is required")
    private String email;

    @UsernameUnique(message = "Username already exists")
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "password is required")
    private String password;

    @NotEmpty(message = "firstname is required")
    private String firstname;

    @NotEmpty(message = "lastname is required")
    private String lastname;
}
