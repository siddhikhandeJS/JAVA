package com.code;

import java.util.Scanner;
//1:Write a program to create student class with 

//data members rollno,marks1,mark2,mark3.
//Accept data (acceptInfo()) and display  using display member function. 
//Also display total,percentage and grade.

public class Student {
	Scanner sc = new Scanner(System.in);
	private int rollno, m1, m2, m3, total;
	private String name;
	private float per;

	public void acceptInfo() {
		System.out.println("Enter rollno, name, mark1, mark2, mark3");
		rollno = sc.nextInt();
		name = sc.next();
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
	}

	public void calculateMarks() {
		this.total = m1 + m2 + m3;
		this.per = total / 3;
	}

	public void display() {
		System.out.println("Student details:");
		System.out.println(
				"Rollno:  " + rollno + "  Name: " + name + "  Marks for 3 subjects: " + m1 + " " + m2 + " " + m3);
		System.out.println("Total of marks is " + total + " Percentage: " + per);
		if (this.per > 85 || this.per <= 100)
			System.out.println("Grade A");
		else if (this.per > 60)
			System.out.println("Grade B");
		else if (this.per > 50)
			System.out.println("Grade C");
		else if (this.per > 35 || this.per > 0)
			System.out.println("Grade D");
		else
			System.out.println("Fail");
	}
}
