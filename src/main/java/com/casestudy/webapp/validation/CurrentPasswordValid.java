package com.example.module309.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CurrentPasswordValidImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public class CurrentPasswordValid implements Annotation {

    String message() default "{CurrentPasswordValid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
