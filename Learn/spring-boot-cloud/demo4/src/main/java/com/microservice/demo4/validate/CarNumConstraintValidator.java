package com.microservice.demo4.validate;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Objects;

public class CarNumConstraintValidator implements ConstraintValidator<CarNumAnnotation, String> {
    @Override
    public void initialize(CarNumAnnotation carNumAnnotation) {

    }

    @Override
    public boolean isValid(String cardNum, ConstraintValidatorContext context) {
        // 根据分隔符拆分字符
        // 1.spring
        // String[] parts = StringUtils.delimitedListToStringArray(cardNum, "-");
        // 2.apache commons.lang
        String[] parts = StringUtils.split(cardNum,"-");
        if (ArrayUtils.getLength(parts) != 2) {
            return false;
        }

        boolean isValidprefix = Objects.equals("sz", parts[0]);
        boolean isValidSuffix = StringUtils.isNumeric(parts[1]);

        return isValidprefix && isValidSuffix;
    }
}
