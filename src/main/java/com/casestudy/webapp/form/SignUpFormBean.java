package com.casestudy.webapp.form;


import com.casestudy.webapp.validation.EmailUnique;
import com.casestudy.webapp.validation.UsernameUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class SignUpFormBean {

    @EmailUnique(message = "Email already exists")
    @NotEmpty(message = "Email is required")
    private String email;

    @Length(max = 50, message = "User name must be less than 50 characters")
    @UsernameUnique(message = "Username already exists")
    @NotEmpty(message = "Username is required")
    private String username;

    @Length(max = 50, message = "Password must be less than 50 characters")
    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Firstname is required")
    private String firstname;

    @NotEmpty(message = "Lastname is required")
    private String lastname;
}
