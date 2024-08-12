package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ProjectDTO;

public interface ProjectService {
//add new project
	ProjectDTO launchNewProject(ProjectDTO newProject);

	List<ProjectDTO> getAllProjects();

	ApiResponse assignEmpToProject(Long projectId, Long empId);
	ApiResponse removeEmpFromProject(Long projectId, Long empId);
	
}
