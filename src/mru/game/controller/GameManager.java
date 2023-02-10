package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	//Array list for storing the player information
	
	ArrayList<Player> players;
	
	// Constant File Path
	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	File db = new File(FILE_PATH);
	
	// For showing menu we created a object from App menu class named as show menu
	AppMenu showMenu;
	
	
	public GameManager() throws FileNotFoundException {
		players = new ArrayList <>();
		loadData();
		launchApplication();
	}
	private void launchApplication() {
		boolean stopLoop = true;
		char option;
		while (stopLoop) {
			option = showMenu.showMainMenu();
			switch (option) {
			case 't':
				playgame();
				break;
			case 'e':
				search();
				break;
			case 's':
				save();
				break;
				stopLoop = false;
			}
		}
		
	}
	private void save() throws IOException {
		PrintWriter pw = new PrintWriter(db);
		
		System.out.println("saving files please wait");
		for (Player items: players) {
			pw.println(items.format());
		}
		pw.close();
		
	}
	private void search() {
		showMenu.showSubMenu();
		char option;
		boolean flag = true;
		while (flag) {
			switch (option) {
			case 't':
				topPlayer();
				break;
			case 'n':
				Player nameFound = lookForName(); 
				break;
			case 'b':
				showMenu.showMainMenu();
				break;
				flag = false;
			}
		}
		
	}
	private Player lookForName() {
		String name = showMenu.promptName();
		Player nameFound = null;
		for (Player names: players) {
			if (names.getName().equals(name)) {
				nameFound = names;
				break;
			}
			else {
				System.out.println("Player not found returning to main menu");
			}
		}
		return nameFound;
	}
	// checks the file it exists or not at startup
	private void loadData() throws FileNotFoundException {
		String [] splittedLines;
		String lines;
		String name;
		int balance;
		int numberOfWins;
		
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			while (fileReader.hasNextLine()) {
				lines = fileReader.nextLine();
				splittedLines = lines.split(",");
				name = splittedLines[0];
				balance = Integer.parseInt(splittedLines[1]);
				numberOfWins = Integer.parseInt(splittedLines[2]);
				Player playerInfo = new Player(name, balance, numberOfWins);
				players.add(playerInfo);
				fileReader.close();
			}
		}
	}

	

}
