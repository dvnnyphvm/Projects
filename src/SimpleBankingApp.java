import java.util.Scanner;

public class SimpleBankingApp {	
	public static void main (String [] args) {
		bankAccount cust = new bankAccount ("Danny Pham");
		cust.showMenu();
	}
}

class bankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	
	//the purpose of a constructor is to initialize the object of a class
	//constructors do not have return types
	//initialize = to give it (ie. object) a value
	
	bankAccount (String name) {
		customerName = name;
	}
	
	void deposit (int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw (int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount; // -ve to indicate that an amount has been withdrawn
		}
	}
	
	void getThePreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited Amount: " + previousTransaction);
		}
		else if (previousTransaction < 0) {
			System.out.println("Withdrawn Amount: " + Math.abs(previousTransaction)); 
			//math absolute is to make it +ve rather than -ve from the withdraw condition
		}
		else {
			System.out.println("No transaction has occurred at this time");
		}
	}
	
	void showMenu () {
		char option = '0';
		Scanner a = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("\n"); //space
		
		//will use a do while loop, which is used to do this set of operations 
		//while the user has not pressed E for exiting the application
		//in other words: this do loop will continue until the user enters E
		//from then the loop breaks and the program exits
		do {
			System.out.println("------------------------------------------------");
			System.out.println("Please choose one of the following options");
			System.out.println("A. Check your current balance");
			System.out.println("B. Deposit funds");
			System.out.println("C. Withdraw funds");
			System.out.println("D. Check your previous transaction");
			System.out.println("E. Exit this application");
			System.out.println("------------------------------------------------");
			option = a.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			//option matches with the letter, so if the user enters A
			// the parameter option will go to case A where it carry out the operation
			case 'A': 
				System.out.println("------------------------------------------------");
				System.out.println("Your current balance is: " + balance);
				System.out.println("------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("------------------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("------------------------------------------------");
				int amount = a.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("------------------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("------------------------------------------------");
				int anotherAmount = a.nextInt();
				withdraw(anotherAmount);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("------------------------------------------------");
				getThePreviousTransaction();
				System.out.println("------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E': 
				System.out.println("*************************************************");
				break;
				
			default:
				System.out.println("This is an invalid option. Please choose from the following options.");
				break;
			}
		} 
		 while (option != 'E');
		
		System.out.println("Thank you for using this simple banking application");
	}
}