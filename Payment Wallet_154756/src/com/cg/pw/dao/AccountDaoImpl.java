package com.cg.pw.dao;

import java.util.HashMap;
import java.util.Scanner;
import com.cg.pw.beans.*;

public class AccountDaoImpl implements AccountDao {
	int result;
	boolean results;
	Scanner in = new Scanner(System.in);
	public static HashMap<String, Account> accountEntry;
	
	public AccountDaoImpl(){
		accountEntry = new HashMap<>();
		accountEntry.put("8295153490",new Account("Rahul","qwertyuiop",500));
		accountEntry.put("9973952350",new Account("Chandra","qwerty",200));
		
	}
	
	public int displayMenu1() {
		System.out.println("\nMenu:");
		System.out.println("\t 1) New User");
		System.out.println("\t 2) Existing User\n");

		System.out.println("\nEnter the choice from the above option.");
		result = in.nextInt();
		return result;
	}

	public int displayMenu2() {
		System.out.println("\nMenu:");
		System.out.println("1) Show Balance");
		System.out.println("2) Deposit");
		System.out.println("3) Withdraw");
		System.out.println("4) Fund Transfer");
		System.out.println("5) Print transaction");
		System.out.println("9) LogOut\n");

		System.out.println("\nEnter the choice from the above option.");
		result = in.nextInt();
		return result;
	}

	public void createAccount(String mobileNumber, String name, String password, double balance) {
		Account a = new Account(name, password, balance);
		accountEntry.put(mobileNumber, a);
		System.out.println("congratulations! your account has been created");
	}

	public double showBalance(String mobileNumber) {
		return accountEntry.get(mobileNumber).getBalance(mobileNumber);
	}

	public void deposit(String mobileNumber, Double depositAmount) {
		accountEntry.get(mobileNumber)
				.setBalance(accountEntry.get(mobileNumber).getBalance(mobileNumber) + depositAmount);
	}
	
	public void withdraw(String mobileNumber,double withdrawAmount)
	{
		accountEntry.get(mobileNumber).setBalance(accountEntry.get(mobileNumber).getBalance(mobileNumber) - withdrawAmount);
	}

	public void transfer(String mobileNumber, String recipientNumber, double transferredAmount) {
		accountEntry.get(mobileNumber).setBalance(accountEntry.get(mobileNumber).getBalance(mobileNumber) - transferredAmount);
		accountEntry.get(recipientNumber).setBalance(accountEntry.get(recipientNumber).getBalance(recipientNumber) + transferredAmount);
	}
	
	public void updatePassbook(String mobileNumber, String trans)
	{
		accountEntry.get(mobileNumber).updatePassbook(trans);
	}

	public void printTransaction(String mobileNumber)
	{
		int size=accountEntry.get(mobileNumber).getPassbook(mobileNumber).size();
		if (size>=5) {
			System.out.println("//");
			for (int i=(size-1);i>=(size-6);i--)
			{
				System.out.println(accountEntry.get(mobileNumber).getPassbook(mobileNumber).get(i));
			}
			System.out.println("//");
		}
		else
		{
			System.out.println("//");
			for (int i=(size-1);i>=0;i--)
			{
				System.out.println(accountEntry.get(mobileNumber).getPassbook(mobileNumber).get(i));
			}
			System.out.println("//");
		}
	}
}
