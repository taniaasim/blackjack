package com.libertymutual.blackjack.model;

import java.util.*;

public class Player {
	private Hand hand;
	private int wallet;
		
	public Player() {
		hand = new Hand();
		wallet = 100;
	}
	
	public Hand getPlayerHand() {
		return hand;
	}
	
	public boolean isBust() {
		int[] values = hand.getValues();
		return values[0] > 21 && values[1] > 21;
	}
	
	public int getAvailableCash() {
		return wallet;
	}
	
	public int ante(int bet) {
		hand = new Hand();
		bet = Math.min(bet, wallet);
		wallet -= bet;
		return bet;
	}

	public void takeCard(Card card) {
		hand.addCard(card);
	}
	
	public List<Card> getCards() {
		return hand.getCards();
	}

	public void payout(int money) {
		wallet += money;
	}
	
	public int getWallet() {
		return wallet;
	}
	
	public boolean hasBlackjack() {
		return hand.isBlackjack();
	}

	public int getBestScore() {
		return hand.getHighestValidValue();
	}
	
	public int[] getPlayerValues() {
		return hand.getValues();
	}
	
}
