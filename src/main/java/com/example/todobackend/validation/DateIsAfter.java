package com.example.todobackend.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidateDateIsAfter.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateIsAfter {
    String message() default "Date Is After";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
