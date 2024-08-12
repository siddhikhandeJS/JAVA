package com.app.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.pojo.Category;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RailwayupdateDTO {

	
	private Long id;
	@NotBlank
	private String Name;
	
	private Category railcat;
	
	private LocalDate start_time;
     
	private LocalDate end_time;

	private String source;
    @NotBlank
	private String destination;

}
