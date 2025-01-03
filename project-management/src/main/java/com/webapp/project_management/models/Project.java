package com.webapp.project_management.models;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String client;
    private String lead;

    @Column(unique = true, nullable = false)
    private String leadEmail;

    @NotNull(message = "The start date is required")
    private LocalDate startDate;

    @NotNull(message = "The end date is required")
    private LocalDate endDate;

    private String category; // In development, Archived
    private String status;   // New, In progress, Testing, Finished
    private String priority; // Low, Medium, High

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