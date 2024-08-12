package com.app.service;

import java.util.List;

import com.app.DTO.StationDTO;
import com.app.DTO.StationUpdateDTO;


;

public interface StationService 
{
	List<StationDTO> getAllstations();
	
	String addStation(StationDTO dto);
	
	String deleteStation(Long id);
	
}
