package com.cns.psm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cns.psm.entities.Project;
import com.cns.psm.entities.ProjectStatus;
import com.cns.psm.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	public Project createProject(Project project) {
		// Validate status
		validateStatus(project.getStatus());
		return projectRepository.save(project);
	}

	public Optional<Project> getProject(Long id) {
		return projectRepository.findById(id);
	}
	
	 public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

	public Project updateProject(Long id, Project projectDetails) {
		Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
		// Validate status
		validateStatus(projectDetails.getStatus());
		project.setName(projectDetails.getName());
		project.setIntro(projectDetails.getIntro());
		project.setOwner(projectDetails.getOwner());
		project.setStatus(projectDetails.getStatus());
		project.setStartDateTime(projectDetails.getStartDateTime());
		project.setEndDateTime(projectDetails.getEndDateTime());
		project.setProjectMembers(projectDetails.getProjectMembers());
		return projectRepository.save(project);
	}

	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

	private void validateStatus(ProjectStatus status) {
		if (status == null) {
			throw new IllegalArgumentException("Status cannot be null");
		}
	}

}
