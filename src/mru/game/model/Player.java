package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	String name;
	int balance;
	int numberOfWins;
	
	// Constructor for the player class
	public Player(String name, int balance, int numberOfWins) {
		this.name = name;
		this.balance = balance;
		this.numberOfWins = numberOfWins;
		}
	// Getters and setters for the player class fields.
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setBalance(int Balance) {
		this.balance = Balance;
	}
	public int getBalance() {
		return balance;
		
	}
	public void setNumberOfWins(int NumberOfWins) {
		this.numberOfWins = NumberOfWins;
	}
	public int getNumberOfWins() {
		return numberOfWins;
	}
	// To String method for the construction of the player details
	
	public String toString() {
		return "Name: " + name + " Balance: " + balance + " Number Of Wins: " + numberOfWins;
	}
	
	public String format() {
		return name+","+balance+","+numberOfWins;
	}
	
	
	
}
