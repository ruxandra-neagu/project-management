package com.webapp.project_management.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.webapp.project_management.validators.DateRange;

@DateRange
public class ProjectDto {
	
	private int id;

    @NotEmpty(message = "The name is required")
    private String name;

    @NotEmpty(message = "The client name is required")
    private String client;

    @NotEmpty(message = "The name of the project lead is required")
    private String lead;

    @NotEmpty(message = "The lead's email is required")
    @Email(message = "Please provide a valid email address")
    private String leadEmail;

    @NotNull(message = "The start date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Start Date must be today or in the past")
    private LocalDate startDate;

    @NotNull(message = "The end date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotEmpty(message = "The category is required")
    private String category;

    @NotEmpty(message = "The status is required")
    private String status;

    private String priority;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }
  
    public void setClient(String client) {
        this.client = client;
    }

    public String getLead() {
        return lead;
    }
  
    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getLeadEmail() {
        return leadEmail;
    }
  
    public void setLeadEmail(String leadEmail) {
        this.leadEmail = leadEmail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
  
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
  
    public LocalDate getEndDate() {
        return endDate;
    }
  
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
  
    public String getCategory() {
        return category;
    }
  
    public void setCategory(String category) {
        this.category = category;
    }
  
    public String getStatus() {
        return status;
    }
  
    public void setStatus(String status) {
        this.status = status;
    }
  
    public String getPriority() {
        return priority;
    }
  
    public void setPriority(String priority) {
        this.priority = priority;
    }
}