package com.app.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "railways")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"clist"})
public class Railway extends BaseEntity {
	
	@Column(length = 20,nullable = false)
	private String Name;
	@Enumerated(EnumType.STRING)
	private Category railcat;
	@Column(nullable = false)
	private LocalDate start_time;
	@Column(nullable = false)
	private LocalDate end_time;
	@Column(length = 20,nullable = false)
	private String source;
	@Column(length = 20,nullable = false)
	private String destination;
	
	@OneToMany(mappedBy = "rail" ,cascade = CascadeType.ALL,orphanRemoval = true)	
	private List<Station> clist=new ArrayList<>();
 
	public void addstation(Station s)
	{
		 this.clist.add(s);
		 s.setRail(this);
	}
	
	public void removestation(Station s)
	{
		this.clist.remove(s);
		s.setRail(null);
	    
	}

}
