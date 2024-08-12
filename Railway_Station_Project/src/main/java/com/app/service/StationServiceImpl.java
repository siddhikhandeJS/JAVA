package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StationDao;
import com.app.dto.StationRespDTO;
import com.app.entities.Railway;
import com.app.entities.Station;


@Service
@Transactional
public class StationServiceImpl implements StationService {

	@Autowired
    private	StationDao stationDao;
	
	@Autowired
	private RailwayService railwayService;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Station addNewStation(StationRespDTO newStation,Long raiwayId) {
		System.out.println("in station service" + newStation);
		Railway railway = railwayService.getRailwayById(raiwayId);
		
		//Station station = mapper.map(newStation, Station.class);
		Station station = new Station();
		station.setName(newStation.getStationName());
		station.setNo_of_platforms(newStation.getNoOfPlatforms());
		station.setStationCode(newStation.getStationCode());
		station.setRailway(railway);
		System.out.println("After mapping"+station);
		return stationDao.save(station);
		
		
	}

	


	


}
