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
	
	public String promptName() {
		 System.out.print("What is your name sir? Name: ");
		 String name = keyboard.nextLine().trim();
		 return name;
	}
	public void showPlayer(Player nameFound) {
		System.out.println(nameFound);
	}
	public void prtintTopPlayer() {
		System.out.format("       -TOP Player-    %n");
		System.out.format("+===========+============+%n");
		System.out.format("|  Name     |    #WINS   |%n");
		System.out.format("+===========+============+%n");
	}
	public void printNameFound() {
		System.out.format("             -Player Info-            %n");
		System.out.format("+===========+============+===========+%n");
		System.out.format("|  Name     | #WINS      | Balance   |%n");
		System.out.format("+===========+============+===========+%n");

	}
	public void showMassage() {
//		String leftAlignFormat = "| %-9s | %-10d |%n";
		System.out.format("********************************************************************%n");
//		System.out.format(leftAlignFormat, name, balance +"%n");
//		System.out.format("********************************************************************%n");
	}
}
