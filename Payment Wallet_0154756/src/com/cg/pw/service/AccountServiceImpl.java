package com.cg.pw.service;

import com.cg.pw.dao.AccountDao;
import com.cg.pw.dao.AccountDaoImpl;
import com.cg.pw.exception.UserExceptions;
import com.cg.pw.service.*;

public class AccountServiceImpl implements AccountService {

	AccountDao mdao = new AccountDaoImpl();
	
	
	@Override
	public void displayMenu1()
	{
		mdao.displayMenu1();
	}
	@Override
	public void displayMenu2()
	{
		mdao.displayMenu2();
	}
	@Override
	public void createAccount(String mobileNumber, String name,String password, double balance)
	{
		 mdao.createAccount(mobileNumber,name,password,balance);
	}
	
	@Override
	public void searchAccount(String mobileNumber) throws UserExceptions
	{
		mdao.searchAccount(mobileNumber);
	}
	
	@Override
	public void matchPassword(String mobileNumber,String password) throws UserExceptions
	{
		mdao.matchPassword(mobileNumber, password);
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
	public void transfer(String mobileNumber, String recipientNumber, double transferredAmount)
	{
		mdao.transfer(mobileNumber, recipientNumber, transferredAmount);
	}
	
}
