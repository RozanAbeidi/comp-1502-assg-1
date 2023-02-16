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
	/**
	 * this constructor is used for calling all other methods present in this class.
	 * also it checks for the player is "new or not" if the player is new it adds him to the data base
	 * accessing the createNewPlayer() method.
	 * @throws IOException
	 */
	public GameManager() throws IOException {
		players = new ArrayList <>();
		showMenu = new AppMenu();
		String leftAlignFormat = "*** Welcome back %-15s | Your Balance is: %-12d ***%n";//adding format string to simplify my print statement.
		String leftAlignFormat2 = "*** Welcome %-15s | Your initial Balance is: %-9d ***%n";//adding format string to simplify my print statement.
		String bottomLine3 = "********************************************************************";//variable for the bottom line. Just for simplifying my print statements.
		loadData();
		String name = showMenu.promptName();
		if (playerLogin(name)) {
			for (Player player: players) {
				if (player.getName().equals(name)) {
					currentPlayer = player;
//					System.out.print("Welcome Back: " + currentPlayer.getName() + " --- Your balance is: " + currentPlayer.getBalance());
					showMenu.showMassage();
					System.out.format(leftAlignFormat, player.getName(), player.getBalance());
					System.out.println(bottomLine3);
				}
			}
		}
		else {
			currentPlayer = createNewPlayer(name);//creating the new player profile.
			System.out.println("Welcome " + currentPlayer.getName() + " --- Your initial balance is: " + currentPlayer.getBalance());
			showMenu.showMassage();
			System.out.format(leftAlignFormat2,currentPlayer.getName(),currentPlayer.getBalance());
			System.out.println(bottomLine3);
		}
		launchApplication();
	}
	/**
	 * this method is responsible for the db is online or not if it is online it takes every single data using a while loop
	 * and it formats the data as a string, int, int, format. This format is done by using parse methods. finally it adds every data
	 * to to the players array list.
	 * @throws FileNotFoundException
	 */
	public void loadData() throws FileNotFoundException {
		String [] splittedLines;
		String lines;
		String name;
		int balance;
		int numberOfWins;
		
// checks the file it exists or not at startup
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			while (fileReader.hasNextLine()) {//checks the whole text file to its ending.
				lines = fileReader.nextLine();
				splittedLines = lines.split(",");
				name = splittedLines[0];
				balance = Integer.parseInt(splittedLines[1]);
				numberOfWins = Integer.parseInt(splittedLines[2]);
				Player playerInfo = new Player(name, balance, numberOfWins);
				players.add(playerInfo);
			}
			fileReader.close();
		}
		}
	/**
	 * this method is launching the whole application.
	 * @param stopLoop which is the boolean set to true it keeps the while loop running unless the user wants to exit.
	 * inside the while loop we have a switch statement where it takes a char from the showMainMenu() method in AppMenu class
	 * and matches the user input with certain cases so that the correct methods are run. And finally when the user wants to exit
	 * it sets the bool to false so the while loop is stooped.
	 * Methods are called inside of this lunchApplication are: 1. playGame(). 2. search(). 3. exit().
	 * @throws IOException
	 */
	private void launchApplication() throws IOException {
		boolean stopLoop = true;
		
		while (stopLoop) {
			char option = showMenu.showMainMenu();
//			System.out.print(option);
			switch (option) {
			case 'p':
//				System.out.print("here");
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
	/**
	 * this method is responsible for taking the whole list of data and bubble sorting the whole integer data.
	 * The highest number of wins are added to the list. it also checks for the player that have the same highest
	 * number of wins
	 * @return topPlayers
	 */
	private ArrayList<Player> topPlayer() {
		ArrayList <Player> topPlayers = new ArrayList<>();
		int numWins = 0;
		for (Player player: players) {//checking the whole player list for their number of wins 
			if (player.getNumberOfWins() > numWins) {
				numWins = player.getNumberOfWins();
				topPlayers.clear();// keeps clearing the player list until certain conditions are meet such as the highest number of wins had been found.
				topPlayers.add(player);//adds the player to new topPlayer list.
			}
			else if (player.getNumberOfWins() == numWins) {//checks the list again to see that two or more players have the same number of wins or not.
				topPlayers.add(player);//adds the player to new topPlayer list.
			}
		}
//		System.out.println(players);
//		System.out.println(topPlayers);
		return topPlayers;
	}
	/**
	 * this method is responsible for writing the file after user finishes playing the game or it a new player is
	 * detected into the system.
	 * Uses print writer method.
	 * @throws IOException
	 */
	private void exit() throws IOException {
		PrintWriter pw = new PrintWriter(db);
		
		System.out.println("Saving files Please wait");
		for (Player items: players) {
			pw.println(items.format());
		}
		pw.close();
		System.out.println("Done saving. See you again very soon. Thank you!!");
		
	}
	/**
	 * this method shows the subMenu from the appMenu class. it has a boolean flag which is responsible for stoping the
	 * while loop based on the users input. it also calls the users chosen methods. this is basically same as showMainMenu
	 * but it shows the showSubMenu().
	 * Methods that are called: 1. topPlayer(), 2.lookForName, 3. showMainMenu(). 
	 */
	private void search() {
//		showMenu.showSubMenu();
		boolean flag = true;
		while (flag) {
			char option = showMenu.showSubMenu();
			switch (option) {
			case 't':
				ArrayList <Player> topPlayers = topPlayer();
				String leftAlignFormat = "| %-9s | %8d   |%n";//adding format string to simplify my print statement.
				String bottomLine = "+-----------+------------+%n";//adding format string to simplify my print statement.
				showMenu.prtintTopPlayer();
				for (Player topPlayer: topPlayers) {
					System.out.printf(leftAlignFormat, topPlayer.getName(), topPlayer.getNumberOfWins());
					System.out.format(bottomLine);
				}
//				showMenu.prtintTopPlayer();
				break;
			case 'l':
				String leftAlignFormat2 = "| %-9s | %-10d | %8d  |%n";//adding format string to simplify my print statement.
				String bottomLine2 = "+===========+============+===========+%n";//adding format string to simplify my print statement.
				Player nameFound = lookForName();
				showMenu.printNameFound();
				System.out.printf(leftAlignFormat2, nameFound.getName(), nameFound.getNumberOfWins(), nameFound.getBalance());
				System.out.format(bottomLine2);
//				showMenu.showPlayer(nameFound);
				break;
			case 'b':
				showMenu.showMainMenu();
				flag = false;
				break;
			}
		}
		
	}
	/**
	 * this method is responsible for scanning the whole list of players and matching the name that the user entered, and return information aganist it.
	 * As like their banalnce number of wins and so on. 
	 * The for loop scans the list until the name is matched and finally it breaks.
	 * @return name founded on the data base
	 */
	
	private Player lookForName() {
		String name = showMenu.promptName();
		Player nameFound = null;
		for (Player names: players) {//scans the whole player list and look for their name
			if (names.getName().equals(name)) {
				nameFound = names;
				break;
			}
			else {
//				System.out.println("Player not found returning to main menu");
			}
		}
		return nameFound;// after the loop it returns with the actual player.
	}
	
	
		
	/**
	 * This play game method actually calls the punto banco game and a do-while loop is created
	 * which run on the users statement if they want to continue or not which sets the flag to true or false.
	 */
	private void playGame() {
		// TODO Auto-generated method stub
		boolean flag = false;//Initializing the variable;
		String pick = showMenu.showGameMenu();//showing the game menu first.
		do {
			if (currentPlayer.getBalance() >= 100) { //checking their balance is less than 100 or not.
				int bet = showMenu.betAmmount(currentPlayer.getBalance());//taking the user bet amount
				PuntoBancoGame game = new PuntoBancoGame();//creating an object from punto banco game.
				String winner = game.winner();// taking the winner
		if (pick.equals(winner)) {//comparing player input with the winner string;
			currentPlayer.setBalance(currentPlayer.getBalance()+bet);//if condition is met the player wins the betting amount and it gets added to their account.  
			currentPlayer.setNumberOfWins(currentPlayer.getNumberOfWins()+ 1);//also it increases their number of wins by one
			showMenu.showWinner(bet);//showing the winning print format from appmenu class.
			}
		else {
			currentPlayer.setBalance(currentPlayer.getBalance() - bet);//else the player losses the bet amount and it gets deducted from their account.
			showMenu.showLoser(bet);//showing the lossing print format from the appmenu.
		}
//		System.out.println("do You want to Play again?");
		flag = showMenu.playAgain();//showing the prompt if they want to play again or not. 
	}
		else {
			System.out.println("You do not have sufficient amount of balance returning to the main menu");
			showMenu.showMainMenu();
			}
		}
		while(flag);// while the flag is true this loops keeps running.
//		System.out.print(winner);
//		PuntoBancoGame game = new PuntoBancoGame();
//		showMenu.showGameMenu();
		
	}
	/**
	 * this method takes a string name inside of the constructor and checks the players list has the name 
	 * of the user or not. If it has it then it returns true which is used in line 129. 
	 * @param name
	 * @return	true or false.
	 */
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
	/**
	 * this methods is responsible for creating the new player profile and adding them to the players list
	 * which is later saved in the txt file.
	 * @param name
	 * @return new player
	 */
	private Player createNewPlayer(String name) {
		Player player = new Player(name, 100, 0);//String name, integer initial balance, and integer numberOfWins.
		System.out.println(player);
		players.add(player);
		return player;
		
		
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
	


