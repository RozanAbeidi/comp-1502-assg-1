package mru.game.controller;

public class PuntoBancoGame {
	public PuntoBancoGame() {
		deck = new CardDeck();
	}

	public static void main(String[] args) {
//		PuntoBancoGame puntoBancoGame = new PuntoBancoGame();
//		String winner = puntoBancoGame.winner();
//		System.out.print(winner);

		// make a PuntoBancoGame object
		// call its winner() method and print out the result

	}

	/**
	 * In this class you implement the game You should use CardDeck class here See
	 * the instructions for the game rules
	 */
	private CardDeck deck;

	/**
	 * This method is used to draw and add two cards to the banker's hand and the
	 * player's hand. The banker and the player may get a third card based on
	 * certain conditions.
	 */

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

		/**
		 * This is the sequence of code for the game rules that determine whether or not
		 * the player or banker can draw a third card and the winner.
		 * 
		 * @return (playerhand, bankerhand)
		 */
		if (playerhand.score() == 8 || playerhand.score() == 9 || bankerhand.score() == 8 || bankerhand.score() == 9) {

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

		resultstable(playerhand, bankerhand);

		return result(playerhand, bankerhand);
	}

	/**
	 * This method is used get the cards for the player and banker with two
	 * 
	 * @param which are the CardHand playerhand and CardHand bankerhand.
	 * @return void
	 */
	private void resultstable(CardHand playerhand, CardHand bankerhand) {

		String playerFirstCard = cardString(playerhand.get(1));
		String bankerFirstCard = cardString(bankerhand.get(1));
		String playerSecondCard = cardString(playerhand.get(2));
		String bankerSecondCard = cardString(bankerhand.get(2));

		String playerThirdCard = cardString(playerhand.get(3));
		String bankerThirdCard = cardString(bankerhand.get(3));

		System.out.println("+======================+======================+");
		System.out.println("||PLAYER               |BANKER               ||");
		System.out.println("+======================+======================+");
		System.out.printf("| %-20s | %-20s |%n", playerFirstCard, bankerFirstCard);
		System.out.println("+----------------------+----------------------+");
		System.out.printf("| %-20s | %-20s |%n", playerSecondCard, bankerSecondCard);
		System.out.println("+----------------------+----------------------+");
		System.out.printf("| %-20s | %-20s |%n", playerThirdCard, bankerThirdCard);
		System.out.println("+----------------------+----------------------+");
		System.out.printf("|PLAYER POINTS: %-6d |Banker POINtS: %-6d | %n", playerhand.score(), bankerhand.score());
		System.out.println("+======================+======================+");

	}

	/**
	 * This method is used to have the playerhand be able to get a third card from
	 * the deck.
	 * 
	 * @param card
	 * @return card.toString() or ""
	 */
	private String cardString(Card card) {
		if (card == null) {
			return "";
		} else {
			return card.toString();

		}
		// TODO Auto-generated method stub

	}

	/**
	 * This method is used return who the winner is based on the score of the
	 * playerhand and the bankerhand.
	 * 
	 * @param CardHand playerhand and CardHand bankerhand.
	 * @return playerhand wins or bankerhand wins or tie
	 */
	public String result(CardHand playerhand, CardHand bankerhand) {

		if (playerhand.score() > bankerhand.score()) {

			return "playerhand wins";
		}

		if (playerhand.score() < bankerhand.score()) {

			return "bankerhand wins";
		}

		return "tie";

	}
}
