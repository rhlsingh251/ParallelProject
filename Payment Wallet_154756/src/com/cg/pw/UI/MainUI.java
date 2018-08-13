package com.cg.pw.UI;

import java.util.*;

import com.cg.pw.exception.*;
import com.cg.pw.service.*;

public class MainUI {
	public static void main(String[] args) {
		int choice;
		String mobileNumber, name, password, trans;
		AccountService user = new AccountServiceImpl();

		while (true) {
			Scanner in = new Scanner(System.in);
			choice = user.displayMenu1();
			switch (choice) {
			case 1:
				while (true) 
				{
					System.out.println("Enter Mobile number");
					mobileNumber = in.nextLine();
					try {
						user.validateMobileNumber(mobileNumber);
						user.validateDuplicateEntry(mobileNumber);
						break;
					} catch (InvalidMobileNumber e) {

					} catch (DuplicateMobileNumber e) {

					}
				}
				System.out.println("Enter customer name");
				name = in.nextLine();
				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				System.out.println("Enter a password for your account");
				password = in.nextLine();
				System.out.println("If you want to deposit some initial amount, then enter the amount. else enter '0'");
				double balance = in.nextDouble();
				user.createAccount(mobileNumber, name, password, balance);
				break;

			case 2:
				while (true) 
				{
					System.out.println("Enter your Mobile number");
					mobileNumber = in.nextLine();
					try {
						user.validateMobileNumber(mobileNumber);
						user.searchAccount(mobileNumber);
						break;
					} catch (InvalidMobileNumber e) {

					} catch (UserExceptions e) {

					}
				}

				while (true) 
				{
					System.out.println("Enter password");
					password = in.nextLine();
					try {
						user.matchPassword(mobileNumber, password);
						break;
					} catch (UserExceptions e) {

					}

				}

				while (true) {
					choice = user.displayMenu2();
					if (choice == 9) {
						System.out.println(
								"\nyou have been successfully logged out\n thankyou, we hope to see you again\nquitting...\n");
						break;
					}

					switch (choice) {
					case 1:

						System.out.println("Account Balance id: " + user.showBalance(mobileNumber));
						break;

					case 2:
						System.out.println("Enter the amount you want to deposit");
						double depositAmount = in.nextDouble();
						user.deposit(mobileNumber, depositAmount);
						System.out.println("Amount successfully deposited");
						System.out.println("updated Balance id: " + user.showBalance(mobileNumber));
						trans = "Credit \t Self Deposit \t\t " + depositAmount + "\t" + user.showBalance(mobileNumber);
						user.updatePassbook(mobileNumber, trans);
						break;

					case 3:
						double withdrawAmount;
						while(true)
						{
							System.out.println("Enter the amount you want to withdraw");
							withdrawAmount = in.nextDouble();						
							try {
								user.checkWithdrawAmount(mobileNumber, withdrawAmount);
								break;
							} catch (NotEnoughBalance e) {
							
							} catch (NotValidAmount e) {
							
							}
						}
						user.withdraw(mobileNumber, withdrawAmount);
						trans = "Debit \t self withdraw \t\t " + withdrawAmount + "\t" + user.showBalance(mobileNumber);
						user.updatePassbook(mobileNumber, trans);
						System.out.println("your updated Balance is: " + user.showBalance(mobileNumber));
						break;

					case 4:
						String recipientNumber;
						while(true)
						{
						System.out.println("Enter the recipients mobile number");
						recipientNumber = in.nextLine();
							try {
								user.validateMobileNumber(mobileNumber);
								user.searchAccount(recipientNumber);
								break;
							} catch (InvalidMobileNumber e) {
							
							} catch (UserExceptions e) {
							}
						}
						double transferredAmount;
						while(true)
						{
							System.out.println("Enter the amount to be transferred");
							transferredAmount = in.nextDouble();
							try {
								user.checkWithdrawAmount(mobileNumber, transferredAmount);
								break;
							} catch (NotEnoughBalance e) {
								
							} catch (NotValidAmount e) {
							
							}
						}
						user.transfer(mobileNumber, recipientNumber, transferredAmount);
						System.out.println("Amount transferred succesfully");
						System.out.println("your updated Balance is: " + user.showBalance(mobileNumber));
						trans = "Credit \t transfer from " + mobileNumber + " \t " + transferredAmount + "\t"
								+ user.showBalance(recipientNumber);
						user.updatePassbook(recipientNumber, trans);
						trans = "Debit \t transfer to " + recipientNumber + " \t " + transferredAmount + "\t"
								+ user.showBalance(mobileNumber);
						user.updatePassbook(mobileNumber, trans);
						break;

					case 5:
						user.printTransaction(mobileNumber);
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
