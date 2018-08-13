package com.cg.pw.dao;

import java.util.HashMap;
import java.util.Scanner;

import com.cg.pw.exception.*;
import com.cg.pw.exception.*;
import com.cg.pw.beans.*;

public class AccountDaoImpl implements AccountDao {
	int result;
	
	HashMap<String, Account> accountEntry = new HashMap<>();

	public void displayMenu1() {
		System.out.println("\nMenu:");
		System.out.println("\t 1) New User");
		System.out.println("\t 2) Existing User\n");

		
		
	}

	public void displayMenu2() {
		System.out.println("\nMenu:");
		System.out.println("\t 1) Show Balance");
		System.out.println("\t 2) Deposit");
		System.out.println("\t 3) Fund Transfer");
		System.out.println("\t 4) Withdraw");
		System.out.println("\t 5) Print transaction");
		System.out.println("\t 9) Exit\n");

	
		
	}

	public void createAccount(String mobileNumber, String name, String password, double balance) {
		Account a = new Account(name, password, balance);
		System.out.println("uygfsuyg");
		accountEntry.put(mobileNumber, a);
		System.out.println(accountEntry.keySet());
		System.out.println("congratulations! your account has been created");
	}

	public void searchAccount(String mobileNumber) throws UserExceptions {
		System.out.println(mobileNumber + " --");
		System.out.println(accountEntry.keySet());
		if (accountEntry.containsKey(mobileNumber)) {
			System.out.println(accountEntry.containsKey(mobileNumber) + " -\'\'");
			System.out.println();
		} else {
			throw new UserExceptions("Account not found. \nRetry...");
		}
	}

	public void matchPassword(String mobileNumber, String password) throws UserExceptions {
		if (accountEntry.get(mobileNumber).getPassword(mobileNumber).equals(password))
			System.out.println("Authentication Successful. Data retrieving...");
		else
			throw new UserExceptions("Incorrect password");
	}

	public double showBalance(String mobileNumber) {
		return accountEntry.get(mobileNumber).getBalance(mobileNumber);
	}

	public void deposit(String mobileNumber, Double depositAmount) {
		accountEntry.get(mobileNumber)
				.setBalance(accountEntry.get(mobileNumber).getBalance(mobileNumber) + depositAmount);
	}

	public void transfer(String mobileNumber, String recipientNumber, double transferredAmount) {
		accountEntry.get(mobileNumber)
				.setBalance(accountEntry.get(mobileNumber).getBalance(mobileNumber) - transferredAmount);
		accountEntry.get(recipientNumber)
				.setBalance(accountEntry.get(recipientNumber).getBalance(recipientNumber) + transferredAmount);
	}

}
