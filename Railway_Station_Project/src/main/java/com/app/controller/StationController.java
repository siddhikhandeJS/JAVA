package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StationRespDTO;
import com.app.entities.Station;
import com.app.service.StationService;

@RequestMapping("/station")
@RestController
public class StationController {

	@Autowired 
	private StationService stationService;
	
	
	//URL : localhost:8080/railway/
	//Method : POST
	//resp : detached entity of statoin
	@PostMapping("/addNewStation")
	public Station addStation(@RequestBody StationRespDTO station,Long raiwayId) {
		System.out.println("In station ctrller"+station);
		return stationService.addNewStation(station, raiwayId);
	}
	
}
