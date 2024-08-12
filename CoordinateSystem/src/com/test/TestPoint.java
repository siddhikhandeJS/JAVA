package com.test;

import java.util.Scanner;

import com.code.Points2D;

public class TestPoint {

	public static void main(String[] args) {
//5.6 Write TestPoint class with a main method Accept co-ordinates of 2 points
//from user (Scanner) --to create 2 points (p1 & p2)
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter co-ordinates for point for x and y");
		Points2D p1 = new Points2D(sc.nextInt(), sc.nextInt());
		System.out.println("Enter co-ordinates for point for x and y");
		Points2D p2 = new Points2D(sc.nextInt(), sc.nextInt());

//		5.7 Use getDetails method to display point details.(p1's details & p2's details)
		System.out.println("Point 1");
		System.out.println(p1);
		System.out.println("Point 2");
		System.out.println(p2);

//		5.8 Invoke isEqual & display if points are same or different (i.e p1 & p2 are 
//		located at the same position)
		if (p1.isEqual(p2)) {
			System.out.println("Point1 and Point2 located at same position");
		} else {
			System.out.println("Point1 and Point2 are not located at same position");
		}

//		5.9 Display distance between p1 & p2
		System.out.println("Distance between Point1 and Point2 is");
		int dist = (int) p1.calculateDistance(p2);
		System.out.println(dist);

//	Create Array Of Point2D and store 5 objects in it;
		Points2D[] arr = new Points2D[5];
		int index = 0;
		for (int i = 0; i < 5; i++) {
				System.out.println("Enter x and y");
				Points2D point = new Points2D(sc.nextInt(), sc.nextInt());
				arr[index] = point;
				index++;
			}
		System.out.println("Elements of array are");
		for(Points2D p:arr) {
			System.out.println(p);
		}
		}
	}

