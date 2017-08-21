package com.libertymutual.blackjack.model;

public class FaceCard implements Card {

	private String visualRepresentation;
	private String suit;

	public FaceCard(String visualRepresentation, String suit) {
		this.suit = suit;
		this.visualRepresentation = visualRepresentation;
	}

	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSuit();
	}

	public String getVisualRepresentation() {
		return visualRepresentation;
	}

	public String getSuit() {
		return suit;
	}
	
	public int[] getValues() {
		return new int[] { 10, 10 };
	}

	
}
