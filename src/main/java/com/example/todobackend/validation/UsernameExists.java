package com.example.todobackend.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidateUsername.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameExists {
    String message() default "Username exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
