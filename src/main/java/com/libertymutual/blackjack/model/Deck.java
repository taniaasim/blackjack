package com.libertymutual.blackjack.model;

import java.util.*;

public class Deck {

	private int currrentCardIndex;
	private List<Card> cards;

	public Deck() {
		String[] suits = new String[] { "Hearts", "Diamonds", "Clubs", "Spades"};
		cards = new ArrayList<Card>();
		for (String suit : suits) {
			cards.add(new AceCard(suit));
			cards.add(new FaceCard("Jack", suit));
			cards.add(new FaceCard("Queen", suit));
			cards.add(new FaceCard("King", suit));
			
			for (int i = 2; i < 11; i++) {
				cards.add(new NumberCard(i, suit));
			}
		}		
	}
	
	public void printThis() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
	
	public Card getCard() {
		if (currrentCardIndex >= cards.size()) {
			return null;
		}
		Card cardToReturn = cards.get(currrentCardIndex);
		currrentCardIndex++;
		return cardToReturn;
	}
	
	public int getDeckSize() {
		return cards.size();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
	public int getNumberOfCardsLeft() {
		return cards.size() - currrentCardIndex;
	}
	
}















