package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name = "emps") 
@Getter
@Setter
@ToString(exclude = {"dept","projects"},callSuper = true)
public class Employee extends BaseEntity {

	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 30, unique = true) // =>unique
	private String email;
	@Column(nullable = false) // =>NOT NULL
	private String password;		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private EmpType type;
	//@Lob // large object :col : longblob
	//private byte[] image;
	private String imagePath;
	private double salary;
	// many to one association
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
	private Department dept;
	// many-to many : non owning
	@ManyToMany(mappedBy = "emps")
	private Set<Project> projects = new HashSet<>();
	// one to one association Employee ----> AdharCard
//	@Embedded // OPTIONAL
//	private AdhaarCard card;
//	// Employee HAS-A skills (string)
//	@ElementCollection // mandatory
//	@CollectionTable(name = "emp_skills", joinColumns = @JoinColumn(name = "emp_id"))
//	@Column(name = "skill_name", length = 20)
//	private List<String> skills = new ArrayList<>();
//	// one to many association between Employee 1--->* PaymentCard
//	@ElementCollection
//	@CollectionTable(name = "emp_payment_cards", 
//	joinColumns = @JoinColumn(name = "emp_id"))
//	private List<PaymentCard> cards = new ArrayList<>();

	
	public void addProject(Project p)
	{
		projects.add(p);
		p.getEmps().add(this);
	}
	public void removeProject(Project p)
	{
		projects.remove(p);
		p.getEmps().remove(this);
	}

//	public AdhaarCard getCard() {
//		return card;
//	}
//
//	public void setCard(AdhaarCard card) {
//		this.card = card;
//	}

	// Tip : NEVER add any association fields in toString : o.w will
}
