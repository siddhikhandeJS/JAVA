package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProjectDTO;
import com.app.dto.ProjectEmp;
import com.app.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	public ProjectController() {
		System.out.println("in ctor of " + getClass());
	}
	//launch new project
	// http://host:port/projects , method=POST
	@PostMapping
	public ResponseEntity<?> launchNewProject(@RequestBody @Valid ProjectDTO project) {
		System.out.println("in add proj " + project);
		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.launchNewProject(project));
	}

	
	// http://host:port/projects , method=GET
	// chk for select n+1 issue ????????????
	@GetMapping
	public ResponseEntity<?> getAllProjects() {
		System.out.println("in get all projs");
		return ResponseEntity.ok(projectService.getAllProjects());
	}

	// http://host:port/projects/employees , method=POST
	@PostMapping("/employees")
	public ResponseEntity<?> addEmployeeToProject(@RequestBody ProjectEmp projectEmp) {
		System.out.println("in add emp to proj " + projectEmp);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(projectService.assignEmpToProject(projectEmp.getProjectId(), projectEmp.getEmployeeId()));
	}

	// http://host:port/projects/employees , method=DELETE
	@DeleteMapping("/employees")
	public ResponseEntity<?> removeEmployeeFromProject(@RequestBody ProjectEmp projectEmp) {
		System.out.println("in rem emp to proj " + projectEmp);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(projectService.removeEmpFromProject(projectEmp.getProjectId(), projectEmp.getEmployeeId()));
	}

}
