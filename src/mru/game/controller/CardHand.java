package mru.game.controller;

import java.util.ArrayList;

public class CardHand {

	@Override
	public String toString() {
		return "CardHand [heldCards=" + heldCards + "]";
	}

	private ArrayList<Card> heldCards;

	public CardHand(ArrayList<Card> cards) {
		heldCards = cards;
	}

	public CardHand() {
		heldCards = new ArrayList<>();
	}

	public int score() {
		int totalScore = 0;

		for (Card card : heldCards) {
			totalScore = totalScore + cardValue(card.getRank());
		}
		return totalScore % 10;

	}

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

	public int numCards() {
		return heldCards.size();
	}

	public static void main(String[] args) {
//		CardDeck deck = new CardDeck();
//		CardHand playerhand = new CardHand(new ArrayList<Card>());
//		CardHand bankerhand = new CardHand(new ArrayList<Card>());

	}

	public Card get(int i) {
		// TODO Auto-generated method stub
		if (i > numCards()) {
			return null;
		} else {
			return heldCards.get(i - 1);
		}
	}

}