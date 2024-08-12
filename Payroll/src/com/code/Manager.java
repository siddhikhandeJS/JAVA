package com.code;

public class Manager extends Employee {
	private double incentives;
	private int deptNo;

	public Manager(int id, String name, String city, int age, int deptNo, double salary, double incentives) {
		super(id, name, city, age);
		this.deptNo = deptNo;
		this.incentives = incentives;
		this.salary = salary;
	}

	@Override
	public void calSalary() {
		salary = salary + incentives;
		System.out.println("salary");
	}

	public String toString() {
		return super.toString() + " " + " deptNo: " + deptNo + " incentives:" + incentives;
	}

}
