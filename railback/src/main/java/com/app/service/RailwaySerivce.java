package com.app.service;

import java.util.List;

import com.app.DTO.RailwayDTO;
import com.app.DTO.RailwayupdateDTO;
import com.app.pojo.Railway;

public interface RailwaySerivce
{
   List<RailwayDTO> getrailinfo();
   
   public String addrailservice(RailwayDTO r);
   
   RailwayDTO getbyId(Long id);
   
   String deletebyId(Long id);
   
   String updatebyId(RailwayupdateDTO r);
}
