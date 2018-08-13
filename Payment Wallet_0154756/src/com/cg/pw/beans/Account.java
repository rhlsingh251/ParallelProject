package com.cg.pw.beans;

public class Account {
	private String mobileNumber;
	private String customerName;
	private String password;
	private double accountBalance;
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
}
