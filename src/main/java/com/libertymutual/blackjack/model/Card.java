package com.libertymutual.blackjack.model;

public interface Card {

	String getSuit();

	String getVisualRepresentation();

	int[] getValues();

}