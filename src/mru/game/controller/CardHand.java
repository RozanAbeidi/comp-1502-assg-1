package mru.game.controller;

import java.util.ArrayList;

public class CardHand {

	@Override
	public String toString() {
		return "CardHand [heldCards=" + heldCards + "]";
	}

	/**
	 * This ArrayList method is used to cards are held in the player's hand and the
	 * banker's hand.
	 */

	private ArrayList<Card> heldCards;

	public CardHand(ArrayList<Card> cards) {
		heldCards = cards;
	}

	public CardHand() {
		heldCards = new ArrayList<>();
	}

	/**
	 * This method is used to calculate the score based on the rank and the face
	 * cards(Queen, King, Jack) are worth zero.
	 */
	public int score() {
		int totalScore = 0;

		for (Card card : heldCards) {
			totalScore = totalScore + cardValue(card.getRank());
		}
		return totalScore % 10;

	}

	/**
	 * This method is used to return zero for the face cards(Queen, King, Jack).
	 */

	private int cardValue(int rank) {
		if (rank >= 10)
			// TODO Auto-generated method stub
			return 0;
		else
			return rank;
	}

	public void add(Card card) {
		heldCards.add(card);
	}

	/**
	 * This method is used for how many cards there are for the player and the
	 * banker.
	 */
	public int numCards() {
		return heldCards.size();
	}

	public static void main(String[] args) {
//		CardDeck deck = new CardDeck();
//		CardHand playerhand = new CardHand(new ArrayList<Card>());
//		CardHand bankerhand = new CardHand(new ArrayList<Card>());

	}

	/**
	 * This method is used to get make sure that cards that the cards the player and
	 * the banker get are not out of bound.
	 */
	public Card get(int i) {
		// TODO Auto-generated method stub
		if (i > numCards()) {
			return null;
		} else {
			return heldCards.get(i - 1);
		}
	}

}