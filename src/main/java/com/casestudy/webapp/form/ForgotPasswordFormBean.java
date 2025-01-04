package com.casestudy.webapp.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgotPasswordFormBean {

    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "new password is required")
    private String password;

    @NotEmpty(message = "firstname is required")
    private String firstname;

    @NotEmpty(message = "lastname is required")
    private String lastname;
}
