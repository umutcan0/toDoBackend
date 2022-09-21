package com.example.todobackend.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidateEmail.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExists {
    String message() default "Email exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
