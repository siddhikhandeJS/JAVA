package com.app.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.RailwayDTO;
import com.app.DTO.RailwayupdateDTO;
import com.app.service.RailwaySerivce;

import io.swagger.v3.core.jackson.ApiResponsesSerializer;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("railways")
@CrossOrigin(origins = "http://localhost:3000")
@NoArgsConstructor
public class RailwayController {
	
	@Autowired
	private RailwaySerivce rail;

	@GetMapping
	public ResponseEntity<?> getrailways()
	{
		return ResponseEntity.ok(rail.getrailinfo());
	}
	
	@PostMapping("/rail")
	public ResponseEntity<?> addrail(@RequestBody @Valid RailwayDTO rail1)
	{
		return ResponseEntity.ok(rail.addrailservice(rail1));
	}
	
	@GetMapping("/{Id}")
//	@RequestMapping(method=RequestMethod.GET, value="/rail/{id}")
	public ResponseEntity<?> getbyID(@PathVariable Long Id)
	{
		return ResponseEntity.ok(rail.getbyId(Id));
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> deletebyId(@PathVariable Long Id)
	{
		return ResponseEntity.ok(rail.deletebyId(Id));
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updatemp(@RequestBody RailwayupdateDTO rr)
	{
		return ResponseEntity.ok(rail.updatebyId(rr));
	}
	
	
	
   
}
