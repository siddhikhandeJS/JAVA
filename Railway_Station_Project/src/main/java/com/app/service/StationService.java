package com.app.service;

import com.app.dto.StationRespDTO;
import com.app.entities.Station;

public interface StationService {
	
	Station addNewStation(StationRespDTO station,Long railwayId);

}
