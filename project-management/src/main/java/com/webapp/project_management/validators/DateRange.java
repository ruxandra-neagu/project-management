package com.webapp.project_management.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateRangeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateRange {
  String message() default "End date must be after start date and cannot be the same as start date";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}