package com.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
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

import com.app.DTO.StationDTO;

import com.app.service.StationService;


@RestController
@RequestMapping("/station")
@CrossOrigin(origins = "http://localhost:3000")
public class StationController 
{
	@Autowired
	private StationService service;
	    
	@GetMapping
	 public ResponseEntity<?> getAllStations()
	{
		return ResponseEntity.ok(service.getAllstations());
	}	
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addstation(@RequestBody @Valid StationDTO dto)
	{
		return ResponseEntity.ok(service.addStation(dto));
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<?> deleted(@PathVariable Long Id)
	{
		return ResponseEntity.ok(service.deleteStation(Id));
	}

	
}

