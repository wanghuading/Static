package com.microservice.persistence.validater;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { UserConstraint.class })
public @interface UserValidator {
    String message() default "{user.validation.constraints.name.format}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
