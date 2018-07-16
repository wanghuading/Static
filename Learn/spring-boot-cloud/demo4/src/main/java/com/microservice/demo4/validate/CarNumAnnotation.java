package com.microservice.demo4.validate;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = CarNumConstraintValidator.class
)
public @interface CarNumAnnotation {
    String message() default "{CarNumAnnotation.user.cardNum.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
