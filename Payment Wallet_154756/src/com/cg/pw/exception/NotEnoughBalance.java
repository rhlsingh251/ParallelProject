package com.cg.pw.exception;

public class NotEnoughBalance extends Exception{
	
	public NotEnoughBalance(){
		System.out.println("Sorry, this transaction can't be performed as the balance of your amount is less than the entered amount/n");
	}
}