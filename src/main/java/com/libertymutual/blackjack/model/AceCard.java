package com.libertymutual.blackjack.model;

public class AceCard implements Card {
	
	private String suit;

	public AceCard(String suit) {
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSuit();
	}

	/* (non-Javadoc)
	 * @see com.theironyard.not.blackjack.models.Cart#getSuit()
	 */
	@Override
	public String getSuit() {
		return suit;
	}
	
	/* (non-Javadoc)
	 * @see com.theironyard.not.blackjack.models.Cart#getVisualRepresentation()
	 */
	@Override
	public String getVisualRepresentation() {
		return "Ace";
	}
	
	/* (non-Javadoc)
	 * @see com.theironyard.not.blackjack.models.Cart#getValues()
	 */
	@Override
	public int[] getValues() {
		return new int[] { 1, 11 };
	}
	
}
