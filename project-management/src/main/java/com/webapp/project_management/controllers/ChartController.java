package com.webapp.project_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.webapp.project_management.models.Project;
import com.webapp.project_management.repositories.ProjectRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/charts")
public class ChartController {

  @Autowired
  private ProjectRepository projectRepo;

  // Define all possible statuses
  private static final List<String> ALL_STATUSES = List.of("New", "In Progress", "Testing", "Finished");

  @GetMapping("/pie-chart")
  public String getChartPage(
          @RequestParam(value = "groupBy", defaultValue = "status") String groupBy,
          Model model) {

      // Retrieve all projects
      List<Project> projects = projectRepo.findAll();

      // Group projects by the specified field and count them
      Map<String, Long> projectsGrouped = projects.stream()
              .collect(Collectors.groupingBy(Project::getStatus, Collectors.counting()));

      // Create a map to hold counts for all statuses, initializing counts to zero
      Map<String, Long> statusCounts = new HashMap<>();
      for (String status : ALL_STATUSES) {
          statusCounts.put(status, projectsGrouped.getOrDefault(status, 0L));
      }

      // Set the chart title
      model.addAttribute("chartTitle", "Projects by Status");

      // Extract labels and counts
      List<String> labels = new ArrayList<>(statusCounts.keySet());
      List<Long> values = labels.stream()
              .map(statusCounts::get)
              .collect(Collectors.toList());

      // Debugging output
      System.out.println("Labels: " + labels);
      System.out.println("Values: " + values);

      // Add data to the model
      model.addAttribute("labels", labels);
      model.addAttribute("values", values);
      model.addAttribute("groupBy", groupBy);

      return "charts/pie-chart";
  }
}