package com.app.org;

public class Manager extends Employee {
	private double perfBonus;

	public Manager(int id, String name, int deptId, double basicSalary, double perfBonus) {
		super(id, name, deptId, basicSalary);
		this.perfBonus = perfBonus;
	}

	@Override
	public String toString() {
		return "Manager Details" + super.toString()+" perfBonus= "+ getPerfBonus() +" computeNetSalary()="
				+ computeNetSalary();
	}

	public double computeNetSalary() {
		this.basicSalary = this.basicSalary + this.perfBonus;
		return this.basicSalary;
	}

	public double getPerfBonus() {
		return perfBonus;
	}

}
