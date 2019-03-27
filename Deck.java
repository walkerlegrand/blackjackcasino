package com.java.blackjack;

import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	//Constructor that creates and shuffles deck when instance is initialized
	Deck() {
		resetDeck();
	}
	
	//List of cards in deck
	private LinkedList<Card> unshuffledDeck = new LinkedList<Card>();
	public LinkedList<Card> deck = new LinkedList<Card>();
	
	//Creates brand new deck of cards, unshuffled 
	private void createDeck() {
		unshuffledDeck.clear();
		for(int x = 0; x < 4; x++){
			for(int y = 0; y < 13; y++){
				Card tempCard = new Card(x,y);
				unshuffledDeck.push(tempCard);
			}
		}
	}
	
	// Randomly selects cards from unshuffled deck and pushes them to new deck, thus shuffling
	private void shuffle() {
		deck.clear();
		int cardsLeft = 52;
		Random rand = new Random();
		int shflr;
		while(cardsLeft > 0) {
			shflr = rand.nextInt(cardsLeft);
			deck.push(unshuffledDeck.remove(shflr));
			cardsLeft--;
		}
	}
	
	//Creates new deck and shuffles
	public void resetDeck(){
		createDeck();
		shuffle();
	}
}
