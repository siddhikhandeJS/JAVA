package com.app.DTO;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationDTO {
	
    
	 private Long id;
	 @NotBlank
	 private String station_code;
	   
	  @NotBlank
	private String station_name;
		
    
	private int No_of_platforms;
	
	private Long railway_id;
		

}
