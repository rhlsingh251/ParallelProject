package com.cg.pw.UI;

import java.util.Scanner;

import com.cg.pw.exception.*;
import com.cg.pw.service.*;

public class MainUI {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UserExceptions {
		int choice1, choice2; Scanner sc; 
		String mobileNumber, mobileNumber1, name, password;
		AccountService user = new AccountServiceImpl();
		sc= new Scanner(System.in);
		
		while (true) {
			
		
			user.displayMenu1();
			System.out.println("\nEnter the choice from the above option.");
			
			choice1 = sc.nextInt();
	
			switch (choice1) {
			case 1:
				System.out.println("Enter Mobile number");
				sc.next();
				mobileNumber = sc.nextLine();
				System.out.println(mobileNumber);
				System.out.println("Enter customer name");
				name = sc.nextLine();
				System.out.println("Enter a password for your account");
				password = sc.nextLine();
				System.out.println("If you want to deposit some initial amount, then enter the amount. else enter '0'");
				double balance = sc.nextDouble();
				user.createAccount(mobileNumber, name, password, balance);
				break;

			case 2:
				System.out.println("klhdklg");
				String a = sc.next();
				System.out.println(a);
				System.out.println("Enter your Mobile number");
				sc.next();
				String mobile = sc.next();
				System.out.println(mobile+"no entry");
				
				try {
					user.searchAccount(mobile);
				} catch (UserExceptions e) {
					break;
				}

				System.out.println("Enter password");
				password = sc.nextLine();
				try {
					user.matchPassword(mobile, password);
				} catch (UserExceptions e) {
					break;
				}

				while (true) {
					System.out.println("\nEnter the choice from the above option.");
					choice2 = sc.nextInt();
					user.displayMenu2();
					if (choice2 == 9) {
						System.out.println(
								"\nyou have been successfully logged out\n thankyou, we hope to see you again\nquitting...\n");
						break;
					}

					switch (choice2) {
					case 1:

						System.out.println("Account Balance id: " + user.showBalance(mobile));
						break;

					case 2:
						System.out.println("Enter the amount you want to deposit");
						double depositAmount = sc.nextDouble();
						user.deposit(mobile, depositAmount);
						System.out.println("Amount successfully deposited");
						System.out.println("updated Balance id: " + user.showBalance(mobile));
						break;

					case 3:
						System.out.println("Enter the recipients mobile number");
						sc.next();
						String recipientNumber=sc.nextLine();
						System.out.println("Enter the amount to be transferred");
						double transferredAmount=sc.nextDouble();
						user.transfer(mobile, recipientNumber, transferredAmount);
						System.out.println("Amount transferred succesfully");
						System.out.println("your updated Balance id: " + user.showBalance(mobile));
						
					default:
						System.out.println("Enter the correct option");
						break;
					}

				}

			default:
				System.out.println("Enter the correct option");
				break;
			}
			
		}
	}
}
