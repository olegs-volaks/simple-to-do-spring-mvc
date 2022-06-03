package com.ovolaks.simpletodo.application.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class ConfirmValidator implements ConstraintValidator<Confirm, Object> {

    private String baseField;
    private String confirmFiled;

    @Override
    public void initialize(Confirm constraintAnnotation) {
        baseField = constraintAnnotation.baseField();
        confirmFiled = constraintAnnotation.confirmFiled();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Object baseFieldValue = getFieldValue(value, baseField);
            Object matchFieldValue = getFieldValue(value, confirmFiled);
            return baseFieldValue != null && baseFieldValue.equals(matchFieldValue);
        } catch (Exception e) {
            // log error
            return false;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

}
