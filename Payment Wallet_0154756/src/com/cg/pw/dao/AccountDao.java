package com.cg.pw.dao;


import com.cg.pw.exception.UserExceptions;

public interface AccountDao {
	
	void displayMenu1();
	void displayMenu2();
	void createAccount (String mobileNumber, String name, String password,double balance);
	void searchAccount (String mobileNumber) throws UserExceptions ;
	void matchPassword (String mobileNumber, String password) throws UserExceptions ;
	double showBalance (String mobileNumber);
	void deposit (String mobileNumber,Double depositAmount);
	void transfer(String mobileNumber, String recipientNumber, double transferredAmount);

}
