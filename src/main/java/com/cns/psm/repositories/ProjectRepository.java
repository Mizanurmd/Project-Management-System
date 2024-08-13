package com.cns.psm.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cns.psm.entities.Project;
import com.cns.psm.entities.ProjectStatus;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	List<Project> findByStatus(ProjectStatus status);
    List<Project> findByOwner(String owner);
    List<Project> findByStartDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
	
}
