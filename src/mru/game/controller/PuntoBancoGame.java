package mru.game.controller;

public class PuntoBancoGame {
	public PuntoBancoGame() {
		deck = new CardDeck();
	}

	public static void main(String[] args) {
		PuntoBancoGame puntoBancoGame = new PuntoBancoGame();
		String winner = puntoBancoGame.winner();
		System.out.print(winner);

		// make a PuntoBancoGame object
		// call its winner() method and print out the result

	}

	/**
	 * In this class you implement the game You should use CardDeck class here See
	 * the instructions for the game rules
	 */
	private CardDeck deck;

	public String winner() {
		CardHand playerhand = new CardHand();
		CardHand bankerhand = new CardHand();
		Card card = deck.drawCard();
		Card thirdCard = null;

		playerhand.add(card);
		card = deck.drawCard();
		bankerhand.add(card);
		card = deck.drawCard();
		playerhand.add(card);
		card = deck.drawCard();
		bankerhand.add(card);

		if (playerhand.score() == 8 || playerhand.score() == 9 || bankerhand.score() == 8 || bankerhand.score() == 9) {

			System.out.println(playerhand);
			System.out.println(bankerhand);
			resultstable(playerhand, bankerhand);

			return result(playerhand, bankerhand);
		}
		if (playerhand.score() <= 5) {
			thirdCard = deck.drawCard();
			playerhand.add(thirdCard);
		}

		if (thirdCard == null) {
			if (bankerhand.score() <= 5) {
				card = deck.drawCard();
				bankerhand.add(card);
			}

		} else {

			if (playerhand.score() == 2 || playerhand.score() == 3) {
				if (bankerhand.score() <= 4) {
					card = deck.drawCard();
					bankerhand.add(card);
				}
			} else if (playerhand.score() == 4 || playerhand.score() == 5) {
				if (bankerhand.score() <= 5) {
					card = deck.drawCard();
					bankerhand.add(card);
				}
			}

			else if (playerhand.score() == 6 || playerhand.score() == 7) {
				if (bankerhand.score() <= 6) {
					card = deck.drawCard();
					bankerhand.add(card);

				}
			} else if (playerhand.score() == 8) {
				if (bankerhand.score() <= 2) {
					card = deck.drawCard();
					bankerhand.add(card);

				}
			} else if (playerhand.score() == 1 || playerhand.score() == 9 || playerhand.score() == 10
					|| playerhand.score() == 0) {
				if (bankerhand.score() <= 3) {
					card = deck.drawCard();
					bankerhand.add(card);
				}
			}

		}

		System.out.println(playerhand);
		System.out.println(bankerhand);

		resultstable(playerhand, bankerhand);

		return result(playerhand, bankerhand);
	}

	private void resultstable(CardHand playerhand, CardHand bankerhand) {

		System.out.println("+======================+======================+");
		System.out.println("||PLAYER               |BANKER               ||");
		System.out.println("+======================+======================+");
		for (int i = 1; i <= bankerhand.numCards(); i++) {
			System.out.printf("| %-20s | %-20s |%n", playerhand.get(i), bankerhand.get(i));
			System.out.println("+----------------------+----------------------+");

		}

		System.out.printf("|PLAYER POINTS: %-6d |Banker POINTS: %-6d | %n", playerhand.score(), bankerhand.score());
		System.out.println("+======================+======================+");
	}

	public String result(CardHand playerhand, CardHand bankerhand) {

		if (playerhand.score() > bankerhand.score()) {

			return "playerhand wins";
		}

		if (playerhand.score() < bankerhand.score()) {

			return "bankerhand wins";
		}

		return "tie";
	}

//	CardDeck fromDeck = new CardDeck();
//	Card currentCard = fromDeck.getDeck().remove(0);
//	
//			
//	CardDeck fromDeck = new CardDeck();
//	Card currentCard = fromDeck.getDeck().remove(0);

//	String playerFirstCard = playerhand.get(1).toString();
//	String playerThirdCard = "";
//	System.out.println("+======================+======================+");
//	System.out.println("||PLAYER               |BANKER               ||");
//	System.out.println("+======================+======================+");
//	System.out.printf("| %-20s | %-20s |%n", playerFirstCard, bankerhand.get(1));
//	System.out.println("+----------------------+----------------------+");
//	System.out.printf("| %-20s | %-20s |%n", playerhand.get(2), bankerhand.get(2));
//	System.out.println("+----------------------+----------------------+");
//	System.out.printf("| %-20s | %-20s |%n", playerThirdCard, bankerhand.get(3));
//	System.out.println("+----------------------+----------------------+");
//	System.out.printf("|PLAYER POINTS: %-6d |Banker POINtS: %-6d | %n", playerhand.score(), bankerhand.score());
//	System.out.println("+======================+======================+");
//

}
 
