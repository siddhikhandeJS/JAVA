package com.test;

import java.util.Scanner;

import com.code.Book;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter BookID, book name, book author, book price");
		Book b1 = new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
		System.out.println(b1);
	}

}
