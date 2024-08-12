package com.test;

import java.util.Scanner;

import com.code.Point;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point p1 = new Point();
		p1.setX(10);
		p1.getX();
		p1.setY(20);
		p1.getY();
		p1.display();
	}

}
