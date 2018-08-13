package com.cg.pw.exception;

public class NotValidAmount extends Exception{
	
	public NotValidAmount(){
		System.out.println("Invalid amount. Enter an amount greater than 0\n");
	}
}