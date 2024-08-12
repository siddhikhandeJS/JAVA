package com.app.service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.InvalidTimeoutException;

import com.app.custom_exceptions.ResourceNotFoundExceptions;
import com.app.dao.RailwayDao;
import com.app.dto.ApiResponse;
import com.app.dto.RailwayRespDTO;
import com.app.entities.Category;
import com.app.entities.Railway;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {

	@Autowired
	private RailwayDao railwayDao;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public String deleteRailwayDetails(Long Id) {
		if(railwayDao.existsById(Id)) {
			railwayDao.deleteById(Id);
			return "Deleted Railway Details!!!";
		}
		throw new ResourceNotFoundExceptions("Invalid Railway Id!!!");
	}

	

	@Override
	public List<RailwayRespDTO> fecthAllRailwayByCategory(Category category) {
		List<Railway> railwayList=railwayDao.findAllByCategory(category);
		
		return railwayList.stream().map(r->mapper.map(r, RailwayRespDTO.class)).collect(Collectors.toList());
	}



	@Override
	public Railway addNewRailway(RailwayRespDTO newRailway) {
		System.out.println(newRailway);
		 Railway entityRailway = new Railway();

		 LocalTime s_time=LocalTime.parse(newRailway.getStartTime());
		 LocalTime e_time=LocalTime.parse(newRailway.getEndTime());
		
		 if (s_time.isAfter(e_time)) {
		        throw new ResourceNotFoundExceptions("Start time cannot be after end time!!!");
		    }
		 
		   
		 	entityRailway=mapper.map(newRailway,Railway.class);
	        entityRailway.setStartTime(LocalTime.parse(newRailway.getStartTime()));
	        entityRailway.setEndTime(LocalTime.parse(newRailway.getEndTime()));

		
	        return railwayDao.save(entityRailway);
	}



	@Override
	public Railway getRailwayById(Long Id) {
		
		return railwayDao.findById(Id).orElseThrow(()->new ResourceNotFoundExceptions("Invalid railway Id"));
	}

	

	
	
}
