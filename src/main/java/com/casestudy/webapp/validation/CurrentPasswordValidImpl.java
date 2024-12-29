package com.example.module309.validation;

import com.example.module309.database.entity.User;
import com.example.module309.security.AuthenticatedUserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
//import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

public class CurrentPasswordValidImpl implements ConstraintValidator<CurrentPasswordValid, String> {

    public static final Logger LOG = LoggerFactory.getLogger(CurrentPasswordValidImpl.class);

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void initialize(CurrentPasswordValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        User user = authenticatedUserService.loadCurrentUser();

        return passwordEncoder.matches(value, user.getPassword());
    }

}
