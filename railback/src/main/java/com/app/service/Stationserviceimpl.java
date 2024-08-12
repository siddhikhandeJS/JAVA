package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.StationDTO;
import com.app.DTO.StationUpdateDTO;
import com.app.custexception.ResouceNotFoundException;
import com.app.dao.RailDao;
import com.app.dao.StationDao;
import com.app.pojo.Railway;
import com.app.pojo.Station;

@Service
@Transactional
public class Stationserviceimpl implements StationService
{
    @Autowired
    private StationDao sdao;
    
    @Autowired
    private RailDao rdao;

    @Autowired
    private ModelMapper mapper;
    
    
	@Override
	public List<StationDTO> getAllstations() {
		
		List<Station> s1=sdao.findAll();
		s1.forEach((q)->System.out.println(q));
		return sdao.findAll().stream().map((s)->mapper.map(s,StationDTO.class)).collect(Collectors.toList());
	}


	@Override
	public String addStation(StationDTO dto) {
	     Railway r=rdao.findById(dto.getRailway_id()).orElseThrow(()->new ResouceNotFoundException("not an sutiable station..."));
	     
	    Station s=mapper.map(dto,Station.class);
	    s.setRail(r);
	    r.addstation(s);
	   rdao.save(r);
	   return "station added succesfully...";
	}


	@Override
	public String deleteStation(Long id) {
		
	     sdao.deleteById(id);
	     
	     return "deleted succesfully";
	    
	}
	
}
