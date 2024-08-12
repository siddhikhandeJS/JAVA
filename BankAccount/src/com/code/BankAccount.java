package com.code;

/*
 * create BankAccount application for operations 
 * like withdraw ,deposite  and moneyTransfer.  
 * Create menu drive program for bank operations..,balance,email...
 */
public class BankAccount {
	private int bankacc;
	private String name;
	private double balance;
	
	public void withdraw(double amt) {
		this.balance=this.balance-amt;
	}
	public void deposit(double amt) {
	this.balance=this.balance+amt;	
	}
	public void moneyTransfer() {
		
	}
	
	
}
