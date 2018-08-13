package com.cg.pw.beans;

import java.util.ArrayList;

public class Account {
	private String customerName;
	private String password;
	private double accountBalance;
	ArrayList<String> transaction=new ArrayList<>();
	public Account(String customerName, String password, double balance)
	{
		this.customerName = customerName;
		this.password=password;
		this.accountBalance = balance;
	}
	public String getPassword(String mobileNumber)
	{
		return password;
	}
	public double getBalance(String mobileNumber)
	{
		return accountBalance;
	}
	public void setBalance(Double balance)
	{
		accountBalance=balance;
	}
	public void updatePassbook(String trans)
	{
		transaction.add(trans);
	}
	public ArrayList<String> getPassbook(String mobileNumber)
	{
		return transaction;
	}
}
