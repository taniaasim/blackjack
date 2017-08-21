package com.libertymutual.blackjack.model;

import java.util.*;

public class Dealer {
	private Hand hand;
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
		deck.shuffle();
		hand = new Hand();
	}
	
	public int getNumberOfCardsLeft() {
		return deck.getNumberOfCardsLeft();
	}
	
	public boolean isBust() {
		int[] values = hand.getValues();
		return values[0] > 21 && values[1] > 21;
	}
	
	public void startRound() {
		hand = new Hand();
	}
	
	public void finishRound() {
		int[] values = hand.getValues();
		if (values[0] == 21 || values[1] == 21) {
			return;
		}
		while (values[0] < 17 || values[1] < 17) {
			dealCardToSelf();
			values = hand.getValues();
		}
	}
	
	public List<Card> getCards() {
		List<Card> cards = hand.getCards();
		return cards;
	}
	
	public void dealCardToPlayer(Player player) {
		Card card = deck.getCard();
		if (card != null) {
			player.takeCard(card);
		}
	}

	public void dealCardToSelf() {
		Card card = deck.getCard();
		if (card != null) {
			hand.addCard(card);
		}
	}

	public boolean hasBlackjack() {
		return hand.isBlackjack();
	}

	public int getBestScore() {
		return hand.getHighestValidValue();
	}
	
	public int[] getDealerValues() {
		return hand.getValues();
	}
	
}
