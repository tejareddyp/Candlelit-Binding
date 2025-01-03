package com.casestudy.webapp.validation;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UsernameUniqueImpl implements ConstraintValidator<UsernameUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(UsernameUniqueImpl.class);

    @Autowired
    private UserDAO userService;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // these 3 lines are the first 3 lines of every custom validator you build
        // BECAUSE .. we are not checking if this value is empty
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        User user = userService.findByUsernameIgnoreCase(value);

        return (user == null);
    }

}
