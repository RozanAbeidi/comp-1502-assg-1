package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {
	
	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	Scanner keyboard;
	// Constructor for the AppMenu class
	public AppMenu() {
		keyboard = new Scanner(System.in);
	}
	// printing the main menu
	public char showMainMenu() {
		System.out.println("Select one of this options");
		System.out.println("\t(P) Play game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Exit");
		System.out.println("Enter your choice");
		char option = keyboard.nextLine().toLowerCase().charAt(0);
//		System.out.println(option);
		return option;
		
	}
	
	//printing the sub menu
	public char showSubMenu() {
		char option;
		System.out.println("Select one of this options:");
		System.out.println("\t(T) Top player (Most Number Of Wins)");
		System.out.println("\t(L) Looking For a Name?");
		System.out.println("\t(B) Back To Main Menu");
		System.out.println("Enter your choice");
		option = keyboard.nextLine().toLowerCase().charAt(0);
		return option;
	}
	//Prompting user for their name
	public String promptName() {
		 System.out.print("What is your name sir? Name: ");
		 String name = keyboard.nextLine().trim();
		 return name;
	}
	//showing player it was only used for testing and can be called for simplified answers while testing
	public void showPlayer(Player nameFound) {
		System.out.println(nameFound);
	}
	/**
	 * formats the print statement while called provides the skeleton of the top player output format.
	 */
	public void prtintTopPlayer() {
		System.out.format("       -TOP Player-    %n");
		System.out.format("+===========+============+%n");
		System.out.format("|  Name     |    #WINS   |%n");
		System.out.format("+===========+============+%n");
	}
	/**
	 * formats the print statement while called provides the skeleton of the existing player info. output format.
	 */
	public void printNameFound() {
		System.out.format("             -Player Info-            %n");
		System.out.format("+===========+============+===========+%n");
		System.out.format("|  Name     | #WINS      | Balance   |%n");
		System.out.format("+===========+============+===========+%n");

	}
	/**
	 * formats the print statement while called provides the skeleton of the new player output format. this is mostly used for testing.
	 * but i turned it into a final print just to use it.
	 */
	public void showMassage() {
//		String leftAlignFormat = "| %-9s | %-10d |%n";
		System.out.format("********************************************************************%n");
//		System.out.format(leftAlignFormat, name, balance +"%n");
//		System.out.format("********************************************************************%n");
	}
	
	public String showGameMenu() {
		char option;
		String pick;
		System.out.println("What do you want to bet on?");
		System.out.println("\t(P) Player Wins");
		System.out.println("\t(B) Banker Wins");
		System.out.println("\t(T) Tie Game");
		System.out.println("Enter Your Choice please:");
		option = keyboard.nextLine().toLowerCase().charAt(0);
		switch (option) {
		case 't':
			pick = "tie";
			break;
		case 'b':
			pick = "bankerhand wins";
			break;
		case 'p':
			pick = "playerhand wins";
			break;
			default :
				System.out.println("Not a valid input");
				pick = showGameMenu();
		}
			
		return pick;
	}
	public void showWinner(int betAmount){
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.printf("$ Player Won %-8d$ $ \n",betAmount);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	public void showLoser(int betAmount){
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.printf("$ Player Lost  %-7d$ $ \n",betAmount);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	public int betAmmount(int balance) {
		System.out.println("How Much you want to bet");
		String ammount = keyboard.nextLine();
		int amt = Integer.parseInt(ammount);
		if (balance < amt) {
			System.out.println("you do not have enough funds to place this bet");
			return betAmmount(balance);
		}
		return Integer.parseInt(ammount);
	}
	public boolean playAgain() {
		System.out.println("Do you wanna play again?(y/n)");
		char option = keyboard.nextLine().toLowerCase().charAt(0);
		switch (option) {
		case 'y':
			return true;
		case 'n':
			return false;
		default:
			return playAgain();
		}
	}
	/**
	 * Most of the coding logic and code are inspired from
	 * @author Khosro Salmani
	 * Special thanks to our author.
	 * https://www.loom.com/share/8bfd9c43a9bf4ca5bb117fc41bb44c5d
	 * https://www.loom.com/share/16b29c94392e43df8a1bcc691a9a27ef
	 * https://www.loom.com/share/df2d09af32b9416c92400d4c9a94f83e
	 */
}
