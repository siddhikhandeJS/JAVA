package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddEmployeeDTO;
import com.app.dto.EmployeeRespDTO;
import com.app.service.EmployeeService;
import com.app.service.ImageHandlingService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ImageHandlingService imageService;

	//1. add new emp to existing dept
	// http://host:port/employees , method=POST
	@PostMapping
	public ResponseEntity<?> addNewEmployee(@RequestBody @Valid AddEmployeeDTO dto) {
		System.out.println("in add emp " + dto);
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(employeeService.addNewEmployee(dto));
	}
	// 2. http://host:port/employees/departments/{deptId} , method=GET
	//get all emp details for specific dept
		@GetMapping(value = "/departments/{deptId}")
		public ResponseEntity<?> getEmpDetailsByDepartment(@PathVariable Long deptId) throws IOException {
			System.out.println("get emps by dept "+deptId);
			return ResponseEntity.ok(employeeService.getAllEmployeesFromDept(deptId));
		}
		
		// http://host:port/employees/departments/{deptId}/{empId}
		//3.  add req handling method(API end point) to get emp details by emp id n dept id
		@GetMapping("/departments/{deptId}/{empId}")
		//dept id is here just used for validation 
		
		public ResponseEntity<?> getEmpDetailsByDeptAndEmpId(@PathVariable Long deptId,@PathVariable Long empId) {
			System.out.println("in get emp details by dept id n emp id " +deptId+" "+ empId);
			return ResponseEntity.ok(employeeService.getEmpDetails(deptId,empId));
		}
		

		//4. update  emp details
		// http://host:port/employees/{empId} , method=PUT
		@PutMapping("/{empId}")
		public ResponseEntity<?> updateEmployee(@PathVariable Long empId,  @RequestBody @Valid AddEmployeeDTO dto) {
			System.out.println("in update emp " +empId+" "+ dto);
			return ResponseEntity.
					ok(employeeService.updateEmployee(empId,dto));
		}
      //5. delete emp details
		// http://host:port/employees/{empId} , method=DELETE
				@DeleteMapping("/{empId}")
				public ResponseEntity<?> deleteEmployee(@PathVariable Long empId) {
					System.out.println("in update emp " +empId);
					return ResponseEntity.
							ok(employeeService.deleteEmpDetails(empId));
				}
		//6. Upload image
	// http://host:port/employees/images , method=POST
	@PostMapping(value = "/images", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@RequestParam long empId, 
			@RequestParam MultipartFile image)
			throws IOException {
		System.out.println("in upload image " + empId);
		return ResponseEntity.status(HttpStatus.CREATED).body(imageService.uploadImage(empId, image));
	}
//7. download image
	// http://host:port/employees/images/{empId} , method=GET
	@GetMapping(value = "/images/{empId}",
			produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(@PathVariable long empId) throws IOException {
		System.out.println("in download image " + empId);
		return ResponseEntity.ok(imageService.serveImage(empId));
	}	
	
	// 8. Pagination demo
		// Get all emps , paginated
		// http://host:port/employees , method=GET
		// req params : pageNumber , def val 0 , optional
		// pageSize : def val 3 , optional

		@GetMapping
			public ResponseEntity<?> getAllEmpsPaginated(
					@RequestParam(defaultValue = "0", required = false) int pageNumber,
				    @RequestParam(defaultValue = "3", required = false) int pageSize)
	 {
				System.out.println("in get all emps " +pageNumber+" "+pageSize);
				List<EmployeeRespDTO> list = employeeService.
						getAllEmployees(pageNumber,pageSize);
				if (list.isEmpty())
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				// emps found
				return ResponseEntity.ok(list);
			}
		


	
	

}
