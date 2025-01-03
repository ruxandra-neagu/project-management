     package com.webapp.project_management.repositories;

     import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.project_management.models.Project;

     public interface ProjectRepository extends JpaRepository<Project, Integer> {

		Object findByName(String name);
     }
     