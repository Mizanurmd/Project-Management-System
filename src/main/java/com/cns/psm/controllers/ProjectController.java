package com.cns.psm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cns.psm.entities.Project;
import com.cns.psm.entities.ProjectStatus;
import com.cns.psm.services.ProjectService;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
	 @Autowired
	    private ProjectService projectService;

	    @PostMapping
	    public ResponseEntity<Project> createProject(@RequestBody Project project) {
	        if (project.getStatus() == null || !isValidStatus(project.getStatus())) {
	            return ResponseEntity.badRequest().body(null);
	        }
	        Project createdProject = projectService.createProject(project);
	        return ResponseEntity.ok(createdProject);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<Project>> getAllProjects() {
	        List<Project> projects = projectService.getAllProjects();
	        return ResponseEntity.ok(projects);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Project> getProject(@PathVariable Long id) {
	        Optional<Project> project = projectService.getProject(id);
	        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
	        if (projectDetails.getStatus() == null || !isValidStatus(projectDetails.getStatus())) {
	            return ResponseEntity.badRequest().body(null);
	        }
	        Project updatedProject = projectService.updateProject(id, projectDetails);
	        return ResponseEntity.ok(updatedProject);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
	        projectService.deleteProject(id);
	        return ResponseEntity.noContent().build();
	    }

	    private boolean isValidStatus(ProjectStatus status) {
	        return status != null;
	    }
	

}
