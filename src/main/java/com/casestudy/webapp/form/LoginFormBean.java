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
public class CreateCustomerFormBean {

    private Integer id;

    //variable name here must match to the name attribute  in html input field
    @Pattern(regexp = "[A-Za-z0-9\\s]+", message = "Company name must contain only numbers,letters and spaces")
    @Length(max = 50, message = "Company name must be less than 50 characters")
    @NotEmpty(message = "Company name is required")
    private String companyName;

    @Length(max = 50, message = "First name must be less than 50 characters")
    @NotEmpty(message = "First name is required")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters")
    @NotEmpty(message = "Last name is required")
    private String lastName;

}
