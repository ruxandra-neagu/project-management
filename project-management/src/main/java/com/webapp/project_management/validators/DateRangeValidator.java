package com.webapp.project_management.validators;

import com.webapp.project_management.models.ProjectDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, ProjectDto> {

  @Override
  public boolean isValid(ProjectDto projectDto, ConstraintValidatorContext context) {
      if (projectDto.getStartDate() == null || projectDto.getEndDate() == null) {
          return true; 
      }
   
      return projectDto.getEndDate().isAfter(projectDto.getStartDate());
  }
}