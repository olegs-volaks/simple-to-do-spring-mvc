package com.ovolaks.simpletodo.application.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ConfirmValidator.class})
public @interface Confirm {

    String baseField();

    String confirmFiled();


    String message() default "Not confirm";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
