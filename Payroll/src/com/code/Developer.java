package com.code;

public class Developer extends Employee {

	private String tech;
	private String ProjName;
	private double bonus;

	public Developer(int id, String name, String city, int age, String tech, String projName, double salary,
			double bonus) {
		super(id, name, city, age);
		this.tech = tech;
		this.ProjName = projName;
		this.bonus = bonus;
		this.salary = salary;
	}

	@Override
	public void calSalary() {
		salary = salary + bonus;
		System.out.println(salary);
	}

	public String toString() {
		return super.toString() + " Technology: " + tech + " Project Name:" + ProjName + " bonus:" + bonus;
	}

}
