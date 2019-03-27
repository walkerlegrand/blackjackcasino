package com.java.blackjack;

public class Hand {

	// Hand value and number of aces (for determining if ace is 11 or 1)
	private int handTotal = 0;
	private int numAces = 0;
	
	//Default constructor
	Hand() {}
	
	//Constructor that allows input of first card drawn to be added to the total value of the hand
	Hand(Card first) {
		handTotal += first.getValue();
		if(first.getAce() == true) numAces++;
	}
	
	//Function that adds all cards to hand after first one has been drawn
	public int addCard(Card newCard){
		if(newCard.getAce() == true) numAces++;
		handTotal += newCard.getValue();
		if(handTotal > 21 && numAces > 0) {
			handTotal -= 10;
			numAces--;
		}
		return handTotal;		
	}
	
	//Resets the hand after round is over
	public void resetHand() {
		handTotal = 0;
		numAces = 0;
	}
}
