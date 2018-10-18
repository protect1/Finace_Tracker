/* Finance Tracker
author: Lucas Parish
date: 10/5/2018

Summary:
The idea of this program is to help the user keep track of their Finances, but it will require the user to be up to date
and on track of having to enter everything in.

Input:
The user will input how much money they have to spend and then be able to divide up money so they can budget.

Output:
what the user plans on spending and how much they can actually spend

***Main Function***
*/

import java.io.*;
import java.util.Scanner;

public class main_function{
	public static void main(String[] args) throws IOException{
		
		//define variables
		String yes_no_answer = "";
		double totalAmount = 0;
		double plan_spend= 0;
		boolean keep_going = true;
		
		//class variables
		Input_Total_Amount_Available expense = new Input_Total_Amount_Available();
		Menu select = new Menu();
		
		//scanner for user input
		Scanner keyboard = new Scanner(System.in);
		
		//Introduction and ask if they have a file already to go
		System.out.println("Hello, welcome to Finance Tracker. Where we will help you keep track of you finances.");
		System.out.println("Have you already started working with us? (Y/N)");
		yes_no_answer = keyboard.nextLine();
		
		if(yes_no_answer.equals("y") || yes_no_answer.equals("Y")) {
			
			//while loop to keep the menu going until keep_going = false
			while(keep_going == true) {			
			keep_going = select.Display_Menu(totalAmount, keep_going);
			}
		}
		else {
			System.out.println("Great, lets get started on tracking our finances!!!");
			expense.Total_Amount(totalAmount);
			expense.Expenses(totalAmount, plan_spend);
		}
		
		keyboard.close();
		return;
	}
	
}