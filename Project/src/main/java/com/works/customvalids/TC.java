package com.works.customvalids;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TCValid.class})
public @interface TC {

    String message() default "TC Format Problem";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
