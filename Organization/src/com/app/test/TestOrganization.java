package com.app.test;

import java.util.Scanner;

import com.app.org.Employee;
import com.app.org.Manager;
import com.app.org.Worker;

public class TestOrganization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// array to store organization details
		Employee[] arr = new Employee[10];
		int ch, index = 0;
		System.out.println("1.Hire Manager 2.Hire Worker");
		System.out.println("3.Display information of all employees");
		System.out.println("4.display net salary  5.Exit");
		do {
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				if (index < arr.length) {
					System.out.println("Enter ID, name, DeptID, Salary, Bonus");
					Manager mg = new Manager(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextDouble());
					arr[index] = mg;
					index++;
				} else {
					System.out.println("Array is full");
				}
				break;
			case 2:
				if (index < arr.length) {
					System.out.println("Enter ID, name, DeptID, Salary, Hoursworked, HourlyRate");
					Worker wk = new Worker(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt(),
							sc.nextDouble());
					arr[index] = wk;
					index++;
				} else {
					System.out.println("Array is full");
				}
				break;
			case 3:
				for(Employee e:arr) {
					if(e!=null) {
					System.out.println(e);
				}
				}
				break;
			case 4:
				for(Employee e:arr) {
					if(e!=null) {
					System.out.println(e.computeNetSalary());
				}
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid choice");
			}

		} while (ch != 5);
		System.out.println("Thank you");
	}

}
