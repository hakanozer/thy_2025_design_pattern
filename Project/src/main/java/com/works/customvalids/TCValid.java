package com.works.customvalids;

import com.works.utils.ValidUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TCValid implements ConstraintValidator<TC,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidUtil.tcValid(value);
    }

}
