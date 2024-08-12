package com.app.org;

public class Worker extends Employee {
	private int hoursWorked;
	private double hourlyRate;

	public Worker(int id, String name, int deptId, double basicSalary, int hoursWorked, double hourlyRate) {
		super(id, name, deptId, basicSalary);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString() {
		return "Worker hoursWorked=" + hoursWorked + ", hourlyRate=" + hourlyRate + ", basicSalary=" + basicSalary;
	}

	public double computeNetSalary() {
		this.basicSalary = this.basicSalary + (this.hourlyRate * this.hoursWorked);
		return this.basicSalary;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

}
