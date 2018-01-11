package com.lmig.gfc.twentyone.models;

public class Bank {

	private int balance = 100;

	public int getBalance() {
		return balance;
	}

	public boolean setBalance(int balance) {
		this.balance = balance;
		return this.balance >= 0;
	}
 
}
