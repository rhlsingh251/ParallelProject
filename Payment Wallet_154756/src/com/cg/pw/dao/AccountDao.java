package com.cg.pw.dao;

public interface AccountDao {
	
	int displayMenu1();
	int displayMenu2();
	
	void createAccount (String mobileNumber, String name, String password,double balance);
	double showBalance (String mobileNumber);
	void deposit (String mobileNumber,Double depositAmount);
	void withdraw(String mobileNumber,double withdrawAmount);
	void transfer(String mobileNumber, String recipientNumber, double transferredAmount);
	void updatePassbook(String mobileNumber, String trans);
	void printTransaction(String mobileNumber);
}
