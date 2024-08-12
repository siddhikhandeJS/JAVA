package com.code;

public class Book {

	private String bname;
	private int id;
	private String author;
	private double price;

	public Book() {
		super();
		this.id = 101;
		this.bname = "Iki";
		this.author = "John";
		this.price = 1200;
	}

	public Book(int id, String bname, String author, double price) {
		super();
		this.bname = bname;
		this.id = id;
		this.author = author;
		this.price = price;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book bname=" + bname + ", id=" + id + ", author=" + author + ", price=" + price;
	}
	
	

}
