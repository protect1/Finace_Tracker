//Menu

//import java.io.*;
import java.util.Scanner;
import java.io.*;

public class Menu {
	
	//variables
	private double ntotal = 0;
	
	//constructor
	public Menu() {
		ntotal = 0;
	}
	
	/*This function will display the menu
	 * @return display menu
	 */
	public boolean Display_Menu(double total, boolean correct) throws IOException{
		
		//variables
		int answer = 0;
		correct = true;
		Input_Total_Amount_Available choice = new Input_Total_Amount_Available();
		
		//Temporary variable
		total = 400;
		double spend = 0;
		
		//scanner open
		Scanner keyboard = new Scanner(System.in);
		
		//this is a test while loop for error handling
		while(correct == true) {
			
			//menu is displayed and selection is made
			System.out.println("Menu: \n" + "   (1) Add to Total Amount\n" + "   (2) Add Expense\n" + "   (3) Reports\n" + "   (4) Exit");
			answer = keyboard.nextInt();
			
			//if statements so that user can go to the correct page
			//Add to Total Amount
			if(answer == 1) {
				System.out.println("*************Add Total*************");
				ntotal = choice.Add_Total(total);
				
				System.out.printf("You have $%.2f available to you now\n", ntotal);
				keyboard.close();
				return correct;
			}
			//Add e\Expenses
			else if(answer == 2) {
				System.out.println("*************Add Expense*************");
				choice.Expenses(total, spend);
				keyboard.close();
				return correct;
			}
			//Run A Report
			else if(answer == 3) {
				System.out.println("*************Reports*************");
				keyboard.close();
				return correct;
			}
			//Exit the Program
			else if(answer == 4) {
				System.out.println("Goodbye, come back later");
				correct = false;
				keyboard.close();
				return correct;
			}
			else {
				System.out.println("Error, Please select one of the following: ");
				
				//menu is displayed and selection is made
				System.out.println("Menu: \n" + "   (1) Add to Total Amount\n" + "   (2) Add Expense\n" + "   (3) Reports\n" + "   (4) Exit");
			}
		}
		keyboard.close();
		return correct;
	}
}
