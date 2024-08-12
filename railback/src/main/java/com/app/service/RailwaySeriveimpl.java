package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.RailwayDTO;
import com.app.DTO.RailwayupdateDTO;
import com.app.custexception.ResouceNotFoundException;
import com.app.dao.RailDao;
import com.app.dao.StationDao;
import com.app.pojo.Railway;

@Service
@Transactional
public class RailwaySeriveimpl implements RailwaySerivce {

	@Autowired
	private RailDao rdao;

	@Autowired
	private StationDao sdao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<RailwayDTO> getrailinfo() {
		return rdao.findAll().stream().map((s) -> mapper.map(s, RailwayDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String addrailservice(RailwayDTO r) {
		Railway r1 = mapper.map(r, Railway.class);
		rdao.save(r1);
		return "railway has been added";
	}

	@Override
	public RailwayDTO getbyId(Long id) {

		Railway r = rdao.findById(id).orElseThrow(() -> new ResouceNotFoundException("No Such trains"));
		RailwayDTO rdto = mapper.map(r, RailwayDTO.class);
		return rdto;
	}

	@Override
	public String deletebyId(Long id) {
		Railway r = rdao.findById(id).orElseThrow(
				() -> new ResouceNotFoundException("No such trians please enter valid number for deletion"));
		
		rdao.deleteById(id);
		return "deleted successfully";

	}

	@Override
	public String updatebyId(RailwayupdateDTO r1) {

		Railway r = rdao.findById(r1.getId()).orElseThrow(
				() -> new ResouceNotFoundException("No such trains please enter valid number for updation"));
		
		Railway newpersistant = mapper.map(r1, Railway.class);
		rdao.save(newpersistant);
		return "Updated Succesfully..";
	}
}
