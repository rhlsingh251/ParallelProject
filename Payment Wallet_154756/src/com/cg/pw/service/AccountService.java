package com.cg.pw.service;

import com.cg.pw.exception.*;

public interface AccountService {
	
	int displayMenu1();
	int displayMenu2();

	void validateMobileNumber(String mobileNumber) throws InvalidMobileNumber;
	void validateDuplicateEntry(String mobileNumber) throws DuplicateMobileNumber;void searchAccount(String mobileNumber) throws UserExceptions;
	void matchPassword (String mobileNumber, String password) throws UserExceptions ;
	void checkWithdrawAmount(String mobileNumber, double withdrawAmount) throws NotEnoughBalance, NotValidAmount;
	
	void createAccount (String mobileNumber, String name,String password, double balance);
	double showBalance (String mobileNumber);
	void deposit (String mobileNumber,Double depositAmount);
	void withdraw(String mobileNumber,double withdrawAmount);
	void transfer(String mobileNumber, String recipientNumber, double transferredAmount);
	void updatePassbook(String mobileNumber, String trans);
	void printTransaction(String mobileNumber);
	

}
