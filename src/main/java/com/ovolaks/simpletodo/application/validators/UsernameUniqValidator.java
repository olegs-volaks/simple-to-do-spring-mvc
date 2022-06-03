package com.ovolaks.simpletodo.application.validators;

import com.ovolaks.simpletodo.application.services.authentication.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqValidator implements ConstraintValidator<UsernameUniq, String> {

    @Autowired
    private UserManager userManager;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userManager.userExists(value);
    }
}
