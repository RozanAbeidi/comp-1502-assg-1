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
			totalScore = totalScore + card.getRank();
		}
		return totalScore % 10;

	}

	public void add(Card card) {
		heldCards.add(card);
	}

	public int numCards() {
		return heldCards.size();
	}

	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		CardHand playerhand = new CardHand(new ArrayList<Card>());
		CardHand bankerhand = new CardHand(new ArrayList<Card>());

	}

}