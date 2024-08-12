package com.app.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.pojo.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RailwayDTO {
	
	@NotBlank
	private String Name;
	
	private Category railcat;
	
	private LocalDate start_time;
     
	private LocalDate end_time;

	private String source;
    @NotBlank
	private String destination;

}
