package com.cg.pw.exception;

public class DuplicateMobileNumber extends Exception {
	
	public DuplicateMobileNumber(){
		System.out.println("An account with the same mobile number already exists.\n");
	}
}
