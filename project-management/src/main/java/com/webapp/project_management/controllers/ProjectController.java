package com.webapp.project_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.webapp.project_management.models.Project;
import com.webapp.project_management.models.ProjectDto;
import com.webapp.project_management.repositories.ProjectRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    @GetMapping({"", "/"})
    public String getProjects(Model model) {
        var projects = projectRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("projects", projects);

        return "projects/index";
    }

    @GetMapping("/create")
    public String createProjectForm(Model model) {
        ProjectDto projectDto = new ProjectDto();
        model.addAttribute("projectDto", projectDto);

        return "projects/create";
    }

    @PostMapping("/create")
    public String createProject(
        @Valid @ModelAttribute("projectDto") ProjectDto projectDto,
        BindingResult result,
        Model model
    ) {
      if (projectRepo.findByName(projectDto.getName()) != null) {
          result.addError(
                  new FieldError("projectDto", "name", projectDto.getName(), false, null, null, "The name of the project is already used")
          );
      }

      if (result.hasErrors()) {
          model.addAttribute("projectDto", projectDto);
          return "projects/create";
      }

      Project project = new Project();
      project.setName(projectDto.getName());
      project.setClient(projectDto.getClient());
      project.setLead(projectDto.getLead());
      project.setLeadEmail(projectDto.getLeadEmail());
      project.setStartDate(projectDto.getStartDate());
      project.setEndDate(projectDto.getEndDate());
      project.setCategory(projectDto.getCategory());
      project.setStatus(projectDto.getStatus());
      project.setPriority(projectDto.getPriority());

      projectRepo.save(project);

      return "redirect:/projects";
    }
    @GetMapping("/edit")
    public String editProjectForm(Model model, @RequestParam int id) {
        Project project = projectRepo.findById(id).orElse(null);
        if (project == null) {
            return "redirect:/projects";
        }

        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setClient(project.getClient());
        projectDto.setLead(project.getLead());
        projectDto.setLeadEmail(project.getLeadEmail());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setEndDate(project.getEndDate());
        projectDto.setCategory(project.getCategory());
        projectDto.setStatus(project.getStatus());
        projectDto.setPriority(project.getPriority());

        model.addAttribute("project", project);
        model.addAttribute("projectDto", projectDto);

        return "projects/edit";
    }

    @PostMapping("/edit")
    public String editProject(
            @Valid @ModelAttribute("projectDto") ProjectDto projectDto,
            BindingResult result,
            Model model
    ) {
        Project project = projectRepo.findById(projectDto.getId()).orElse(null);
        if (project == null) {
            return "redirect:/projects";
        }

        if (projectRepo.findByName(projectDto.getName()) != null && !project.getName().equals(projectDto.getName())) {
            result.addError(
                    new FieldError("projectDto", "name", projectDto.getName(), false, null, null, "The name of the project is already used")
            );
        }

        if (result.hasErrors()) {
            model.addAttribute("project", project);
            return "projects/edit";
        }

        project.setName(projectDto.getName());
        project.setClient(projectDto.getClient());
        project.setLead(projectDto.getLead());
        project.setLeadEmail(projectDto.getLeadEmail());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setCategory(projectDto.getCategory());
        project.setStatus(projectDto.getStatus());
        project.setPriority(projectDto.getPriority());

        try {
            projectRepo.save(project);
        } catch (Exception ex) {
            result.addError(
                    new FieldError("projectDto", "name", projectDto.getName(), false, null, null, "An error occurred while updating the project")
            );
            model.addAttribute("project", project);
            return "projects/edit";
        }

        return "redirect:/projects";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam int id) {
        Project project = projectRepo.findById(id).orElse(null);
        if (project != null) {
            projectRepo.delete(project);
        }
        return "redirect:/projects";
    }

    
}