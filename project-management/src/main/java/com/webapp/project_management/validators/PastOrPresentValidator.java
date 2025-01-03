package com.webapp.project_management.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PastOrPresentValidator implements ConstraintValidator<PastOrPresent, LocalDate> {

  @Override
  public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
      if (date == null) {
          return true;
      }
      return !date.isAfter(LocalDate.now());
  }
}