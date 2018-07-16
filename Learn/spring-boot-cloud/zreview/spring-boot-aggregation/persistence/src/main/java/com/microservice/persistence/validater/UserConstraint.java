package com.microservice.persistence.validater;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserConstraint implements ConstraintValidator<UserValidator, String> {

    @Override
    public void initialize(UserValidator constraintAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.startsWith("AA-")) {
            return true;
        }
        return false;
    }
}
