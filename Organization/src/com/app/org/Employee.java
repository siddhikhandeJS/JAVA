package com.app.org;

public class Employee {
	private int id;
	private String name;
	private int deptId;
	protected double basicSalary;

	public Employee(int id, String name, int deptId, double basicSalary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.basicSalary = basicSalary;
	}

	@Override
	public String toString() {
		return "Employee id=" + id + ", name=" + name + ", deptId=" + deptId + ", basicSalary=" + basicSalary;
	}

	public double computeNetSalary() {
		return 0;
	}

}
