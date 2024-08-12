package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.ProjectDTO;
import com.app.entities.Employee;
import com.app.entities.Project;
import com.app.repository.EmployeeRepository;
import com.app.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ProjectDTO launchNewProject(ProjectDTO dto) {
		// map dto --> entity
		Project project = mapper.map(dto, Project.class);
		Project savedProject = projectRepo.save(project);
		return mapper.map(savedProject, ProjectDTO.class);
	}

	@Override
	public List<ProjectDTO> getAllProjects() {

		return projectRepo.findAll()
				.stream()
				.map(project -> mapper.map(project, ProjectDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse assignEmpToProject(Long projectId, Long empId) {
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project ID!!!!"));
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!"));
		project.addEmp(emp);// establish bi dir relationship
		return new ApiResponse("Emp " + emp.getFirstName() + " added to Project : " + project.getTitle());
	}

	@Override
	public ApiResponse removeEmpFromProject(Long projectId, Long empId) {
		Project project = projectRepo.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project ID!!!!"));
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!"));
		//remove bi dir link
		project.removeEmp(emp);
		return new ApiResponse("Emp " + emp.getFirstName() + " added to Project : " + project.getTitle());
	}

}
