package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stations")
@ToString 
public class Station extends BaseEntity
{
	@Column(length = 20,nullable = false)
    private String station_code;
   
	@Column(length=20,nullable = false)
	private String station_name;
	
	@Column(nullable = false)
	private int No_of_platforms;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "railway_id", nullable = false)
	private Railway rail;

}
