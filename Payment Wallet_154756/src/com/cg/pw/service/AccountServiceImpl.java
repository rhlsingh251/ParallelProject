package com.cg.pw.service;

import com.cg.pw.dao.*;
import com.cg.pw.exception.*;

public class AccountServiceImpl implements AccountService {

	AccountDaoImpl mdao = new AccountDaoImpl();
	

	@Override
	public int displayMenu1()
	{
		return mdao.displayMenu1();
		
	}
	@Override
	public int displayMenu2()
	{
		return mdao.displayMenu2();
	}
	
	@Override
	public void validateMobileNumber(String mobileNumber) throws InvalidMobileNumber {
		int len=mobileNumber.length();
		if(len!=10)
			throw new InvalidMobileNumber();
	}
	
	@Override
	public void validateDuplicateEntry(String mobileNumber) throws DuplicateMobileNumber {
		if(AccountDaoImpl.accountEntry.containsKey(mobileNumber))
			throw new DuplicateMobileNumber();
	}

	@Override
	public void searchAccount(String mobileNumber) throws UserExceptions
	{
		if (AccountDaoImpl.accountEntry.containsKey(mobileNumber)) {
			System.out.println("Account found.");
		}
		else
		{
			throw new UserExceptions("Account not found. \n retry...");
		}
	}
	@Override
	public void matchPassword(String mobileNumber,String password) throws UserExceptions
	{
		if(AccountDaoImpl.accountEntry.get(mobileNumber).getPassword(mobileNumber).equals(password))
			System.out.println("Password matched. Opening details...");
		else
			throw new UserExceptions("Incorrect password, try again");
	}
	
	@Override
	public void checkWithdrawAmount(String mobileNumber, double withdrawAmount) throws NotEnoughBalance, NotValidAmount
	{
		if(AccountDaoImpl.accountEntry.get(mobileNumber).getBalance(mobileNumber)<withdrawAmount)
			throw new NotEnoughBalance();
		if(withdrawAmount<=0)
			throw new NotValidAmount();
	}
	
	@Override
	public void createAccount(String mobileNumber, String name,String password, double balance)
	{
		 mdao.createAccount(mobileNumber,name,password,balance);
	}
	
	@Override
	public double showBalance (String mobileNumber)
	{
		return mdao.showBalance(mobileNumber);
	}
	
	@Override
	public void deposit (String mobileNumber,Double depositAmount)
	{
		mdao.deposit(mobileNumber, depositAmount);
	}
	
	@Override
	public void withdraw(String mobileNumber,double withdrawAmount)
	{
		mdao.withdraw(mobileNumber,withdrawAmount);
	}
	
	@Override
	public void transfer(String mobileNumber, String recipientNumber, double transferredAmount)
	{
		mdao.transfer(mobileNumber, recipientNumber, transferredAmount);
	}
	
	@Override
	public void updatePassbook(String mobileNumber, String trans)
	{
		mdao.updatePassbook(mobileNumber, trans);
	}
	
	@Override
	public void printTransaction(String mobileNumber)
	{
		mdao.printTransaction(mobileNumber);
	}
}
