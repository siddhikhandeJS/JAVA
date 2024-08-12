package com.app.service;

import java.lang.reflect.Field;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;
import com.app.entities.Employee;
import com.app.repository.AddressRepository;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository adrRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public AddressDTO getAddressDetails(Long addressId) {
		// TODO Auto-generated method stub
		return mapper.map(
				adrRepo.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp  Id Or Address not yet assigned !!!!")),
				AddressDTO.class);
	}

	@Override
	public ApiResponse assignEmpAddress(Long empId,AddressDTO address) {
		//validate emp
		Employee employee = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		// map dtp --> entity
		Address addressEntity = mapper.map(address, Address.class);
		// establish un dir link , adr ---> emp
		addressEntity.setOwner(employee);
		// save adr details
		adrRepo.save(addressEntity);
		return new ApiResponse("Assigned new address to Emp , " 
		+ employee.getFirstName());
	}

	@Override
	public ApiResponse updateEmpAddress(Long empId,AddressDTO address) {
		//validate emp
		Employee employee = empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		// map dtp --> entity
		Address addressEntity = mapper.map(address, Address.class);
		// establish un dir link , adr ---> emp
		addressEntity.setOwner(employee);
		addressEntity.setId(empId);
		// save adr details
		adrRepo.save(addressEntity);
		return new ApiResponse("Updated address for  Emp , " + employee.getFirstName());

	}
	
	@Override
	public AddressDTO patchEmpAddress(Long empId, Map<String, Object> map) {
		// chk if adr exists
		Address address = adrRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Address Id!!!!"));
		//iterate through the map , check which fields are modified n modifies only those 
		map.forEach((name, value) -> {
			Field field = ReflectionUtils.findField(Address.class,name);
			field.setAccessible(true);
			ReflectionUtils.setField(field, address, value);
		});
		System.out.println("updated address "+address);
		return mapper.map(address, AddressDTO.class);
	}

}
