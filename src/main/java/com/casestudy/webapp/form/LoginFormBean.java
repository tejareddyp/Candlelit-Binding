package com.casestudy.webapp.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class LoginFormBean {

    private Integer id;

    //variable name here must match to the name attribute  in html input field
    //@Pattern(regexp = "[A-Za-z0-9\\s]+", message = "Company name must contain only numbers,letters and spaces")
    @Length(max = 50, message = "User name must be less than 50 characters")
    @NotEmpty(message = "User name is required")
    private String username;

    @Length(max = 50, message = "Password must be less than 50 characters")
    @NotEmpty(message = "Password is required")
    private String password;



}
