package com.ovolaks.simpletodo.application.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UsernameUniqValidator.class})
public @interface UsernameUniq {

    String message() default "Username already taken!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
