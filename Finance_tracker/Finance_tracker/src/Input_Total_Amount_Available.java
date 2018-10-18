/* Finance Tracker
author: Lucas Parish
date: 10/5/2018

Summary:
This is going to be the class that will aquire all of the nessary information so the computer knows how much
money the user has.

Input:
The user will input how much money he/she has available and be able to split up how much they plan to spend 

Output:
The amount of money the user has to spend and how they plan on spending it.

****Input_Total_Amount_Available Function *****
*/

import java.io.*;
import java.util.Scanner;


public class Input_Total_Amount_Available{
	
	//define variables
		private double tracker;
		private double left_over;
		private String expense_items;
		private double final_Amount;
		
	public Input_Total_Amount_Available() {
		tracker = 0;
		final_Amount = 0;
		left_over = 0;
		expense_items = "no work";
	}
	
	/*
	 * Gets the total amount the user has to spend
	 * @return the total amount
	 */
	public double Total_Amount(double total_amount_available) throws IOException{
		
		//Initiate the print writer
		PrintWriter pw = new PrintWriter("output.txt");
		
		
		//scanner to read in input from user
		Scanner keyboard = new Scanner(System.in);
		
		//ask the user for input
		System.out.println("Please Enter in the Amount you have to spend");
		total_amount_available = keyboard.nextDouble();
		final_Amount = total_amount_available;
		 pw.println(final_Amount);
		keyboard.close();
		pw.close();
		
		return total_amount_available;
		
	}
	
	/*
	 * user enters expenses that they plan on spending
	 * @return expenses
	 */
	public void Expenses(double totalAmount, double amount_plan_to_spend)throws IOException {
		
		//print writer start
		PrintWriter pw = new PrintWriter("Output.txt");
		
		//scanner to read in input from user
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			
			
			//ask the user for input on they are spending on and how much
			System.out.println("What do you plan to spend your money on? (Press q to stop)");
			expense_items = keyboard.nextLine();
			
			//Check if expense_items == q
			if(expense_items.equals("q") || expense_items.equals("Q")) {
				break;
			}
			else {
				pw.println(expense_items);
			//print to file
			
			}
			System.out.println("How much do you plan to spend?");
			amount_plan_to_spend = keyboard.nextDouble();
			tracker = tracker + amount_plan_to_spend;
			//print to file
			
			//check to make sure amount is less or equal than available amount
			if(tracker > totalAmount) {
				System.out.println("Error, the amount is over what you have available to spend");
				keyboard.close();
				pw.println("Error, the amount is over what you have available to spend");
				pw.close();
				return;
			}
			else if(tracker == totalAmount) {
				System.out.println("You have reached the maxium amount of money you can spend with the current available funds");
				pw.println("You have reached the maxium amount of money you can spend with the current available funds");
				break;
			}
			else {
				left_over = totalAmount - tracker;
				System.out.printf("You have $%.2f available to you\n", left_over);
				pw.printf("You have $%.2f available to you\n", left_over);
			}
		}
		keyboard.close();
		pw.close();
		return;
	}
	
	public double Add_Total(double aTotal) {
		//open scanner for user input
		Scanner keyboard = new Scanner(System.in);
		
		//get amount to add to total while setting up final_Amount
		final_Amount = aTotal;
		System.out.println("Enter in the amount to be added to the existing amount");
		aTotal = keyboard.nextDouble();
		
		//calculate what the new total is
		final_Amount = aTotal + final_Amount;
		keyboard.close();
		return final_Amount;
		
	}
}