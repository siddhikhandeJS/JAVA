package com.code;

public class Employee {
	private int id;
	private String name;
	private String city;
	private int age;
	protected double salary;

	public Employee(int id, String name, String city, int age) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.age = age;
	}

	public void calSalary() {
		this.salary = 20000;
	}

	public String toString() {
		return "Id: " + id + " name:" + name + " city:" + city + " age:" + age + " salary:" + salary;

	}

}
