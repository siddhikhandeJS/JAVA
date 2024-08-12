package com.tester;

import com.code.Developer;
import com.code.Employee;

public class Tester {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Siddhi", "Nashik", 22);
		e1.calSalary();
		System.out.println(e1);

		Developer d1 = new Developer(102, "Rutuja", "Pune", 19, "Java", "PayRoll", 65000, 1200);
		System.out.println(d1);
	}
}
