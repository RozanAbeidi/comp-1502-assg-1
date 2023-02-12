package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	private final String FILE_PATH = "res//CasinoInfo.txt";
	File db = new File(FILE_PATH);
	
	// For showing menu we created a object from App menu class named as show menu
	AppMenu showMenu;
	Player currentPlayer;
	
	public GameManager() throws IOException {
		players = new ArrayList <>();
		showMenu = new AppMenu();
		loadData();
		String name = showMenu.promptName();
		if (playerLogin(name)) {
			for (Player player: players) {
				if (player.getName().equals(name)) {
					currentPlayer = player;
					System.out.println("Welcome Back: " + currentPlayer.getName() + " --- Your balance is: " + currentPlayer.getBalance());
				}
			}
		}
		else {
			currentPlayer = createNewPlayer(name);
			System.out.println("Welcome " + currentPlayer.getName() + " --- Your initial balance is: " + currentPlayer.getBalance());
			
		}
		launchApplication();
	}
	public void loadData() throws FileNotFoundException {
		String [] splittedLines;
		String lines;
		String name;
		int balance;
		int numberOfWins;
		
// checks the file it exists or not at startup
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
			}
		}
		}
	private void launchApplication() throws IOException {
		boolean stopLoop = true;
		
		while (stopLoop) {
			char option = showMenu.showMainMenu();
			System.out.print(option);
			switch (option) {
			case 't':
				System.out.print("here");
				playGame();
				break;
			case 's':
				search();
				break;
			case 'e':
				exit();
				stopLoop = false;
				break;
			}
		}
		
	}
	private ArrayList<Player> topPlayer() {
		ArrayList <Player> topPlayers = new ArrayList<>();
		int numWins = 0;
		for (Player player: players) {
			if (player.getNumberOfWins() > numWins) {
				numWins = player.getNumberOfWins();
				topPlayers.clear();
				topPlayers.add(player);
			}
			else if (player.getNumberOfWins() == numWins) {
				topPlayers.add(player);
			}
		}
//		System.out.println(players);
//		System.out.println(topPlayers);
		return topPlayers;
	}
	private void exit() throws IOException {
		PrintWriter pw = new PrintWriter(db);
		
		System.out.println("saving files please wait");
		for (Player items: players) {
			pw.println(items.format());
		}
		pw.close();
		
	}
	private void search() {
		showMenu.showSubMenu();
		boolean flag = true;
		while (flag) {
			char option = showMenu.showSubMenu();
			switch (option) {
			case 't':
				ArrayList <Player> topPlayers = topPlayer();
				for (Player topPlayer: topPlayers) {
					System.out.println(topPlayer.getName()+" | " + topPlayer.getNumberOfWins());
				}
				break;
			case 'l':
				Player nameFound = lookForName();
				showMenu.showPlayer(nameFound);
				break;
			case 'b':
				showMenu.showMainMenu();
				flag = false;
				break;
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
//				System.out.println("Player not found returning to main menu");
			}
		}
		return nameFound;
	}
	

		
	
	private void playGame() {
		// TODO Auto-generated method stub
	}
	
	private boolean playerLogin(String name) {
		for (Player player: players) {
			if (player.getName().equals(name)) {
//				System.out.println(" true");
				return true;
			}
			
		}
//		System.out.println(" false");
		return false;
	}
	private Player createNewPlayer(String name) {
		Player player = new Player(name, 100, 0);
		System.out.println(player);
		players.add(player);
		return player;
		
		
	}
		
		}
	


