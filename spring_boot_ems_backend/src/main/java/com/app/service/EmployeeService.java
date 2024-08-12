package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.AddEmployeeDTO;
import com.app.dto.ApiResponse;
import com.app.dto.EmployeeRespDTO;

public interface EmployeeService {
//get list of emps from a specific dept
	List<EmployeeRespDTO> getAllEmployeesFromDept(long deptId);

//delete emp details
	ApiResponse deleteEmpDetails(long empId);

	EmployeeRespDTO addNewEmployee(AddEmployeeDTO dto);

	EmployeeRespDTO updateEmployee(Long empId,AddEmployeeDTO dto);

	EmployeeRespDTO getEmpDetails(long deptId, Long empId);
	
	//get all emps : pagination
		List<EmployeeRespDTO> getAllEmployees(int pageNumber,int pageSize);
}
