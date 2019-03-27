/*
	 This is my first Java program.
	 It is an interactive game that allows you to play blackjack through the console.
	 It is very basic, but does follow traditional casino rules, i.e.:
	 	-Dealer hits below 17
	 	-Winning the hand has a 2:1 win-to-bet ratio
	 	-On deal, you are only revealed one of the dealers two cards
	I am not a front-end programmer so, although it would probably be easy, I do not
	know where to begin making a front-end for this, thus why it is a console interactive game.
	You start off with $1000 and there is no minimum or maximum bet.
	This project was coded in Eclipse Neon and I have not tested it in any other environment so 
	I apologize for any bugs that may appear in other environments.
	Happy betting!
	Interaction:
		-"What would you like to bet?" takes any integer within your budget
		-"Hit or stay?" takes input of "hit" or "stay"
		-"Play again?" takes "no" to exit or just press enter to keep playing.
*/
package com.java.blackjack;
import java.util.Scanner;

public class PlayBlackJack {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in); // Reads in user input
		
		// Initialization of all necessary components
		int budget = 1000; // Initializes budget to $1000
		int bet;
		String decision = new String();
		Card card = new Card();
		Card dealersDown = new Card();
		Deck deck = new Deck();
		Hand dealerHand = new Hand();
		Hand myHand = new Hand();
		System.out.printf("Your chips total $%d.\n", budget);
		
		// Starts game and loops while you have money or until you decide you are done
		while (budget > 0) {
			
			// Initializes values of your hand and dealers hand at beginning of each round
			int myHandValue = 0;
			int dealerHandValue = 0;
			
			// Gets users bet value
			System.out.println("What would you like to bet?");
			bet = Integer.parseInt(sc.nextLine());
			
			// Makes sure user has enough money
			if(bet > budget) {
				System.out.println("Not enough money for that bet!");
				continue;
			}
			
			// Adds card to dealers hand
			dealersDown = deck.deck.pop();
			dealerHandValue = dealerHand.addCard(dealersDown);
			for (int x = 0; x < 2; x++) {
				card = deck.deck.pop();
				System.out.println(card.getNum() + card.getSuit());
				myHandValue = myHand.addCard(card);
				java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
				// System.out.printf("Value of hand: %d\n", handValue);
			}
			System.out.printf("Value of hand: %d\n", myHandValue);
			java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
			
			// Draws and displays users face up card
			card = deck.deck.pop();
			dealerHandValue = dealerHand.addCard(card);
			System.out.printf("Dealer shows %s%s\n", card.getNum(), card.getSuit());
			
			// Hit/stay interaction
			while (myHandValue < 21) {
				System.out.println("Hit or stay?");
				decision = sc.nextLine();
				if (decision.equals("hit")) {
					card = deck.deck.pop();
					System.out.println(card.getNum() + card.getSuit());
					myHandValue = myHand.addCard(card);
					System.out.printf("Current hand value is: %d\n", myHandValue);
					java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
				} else if (decision.equals("stay")) {
					break;
				}
			}
			
			// Identifies if you busted or what you finished with if you stayed
			if (myHandValue > 21) {
				System.out.printf("Busted on %d\n", myHandValue);
				System.out.printf("Dealer had %d\n", dealerHandValue);
				budget -= bet;
			} else {
				System.out.printf("Stayed on %d\n", myHandValue);
				java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
				System.out.printf("Dealer had a %s%s!\n", dealersDown.getNum(), dealersDown.getSuit());
				java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
				System.out.printf("Dealer now has %d\n", dealerHandValue);
				java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
				
				//Goes through dealers hit/stay
				while (dealerHandValue < 17) {
					System.out.println("Dealer hit!");
					card = deck.deck.pop();
					System.out.println(card.getNum() + card.getSuit());
					dealerHandValue = dealerHand.addCard(card);
					java.util.concurrent.TimeUnit.MILLISECONDS.sleep(500);
					// System.out.printf("Value of hand: %d\n", handValue);
				}
				if (dealerHandValue > 21) {
					System.out.println("Dealer busted! You win!");
					budget += bet;
				} else if (myHandValue == dealerHandValue) {
					System.out.printf("Dealer stayed on %d\n", dealerHandValue);
					System.out.println("Push. *bump bump*");
				} else if (myHandValue > dealerHandValue) {
					System.out.printf("Dealer stayed on %d\n", dealerHandValue);
					System.out.println("You win!");
					budget += bet;
				} else {
					System.out.printf("Dealer stayed on %d\n", dealerHandValue);
					System.out.println("You lose!");
					budget -= bet;
				}
			}
			
			// Displays new budget after win/loss and asks to play again
			System.out.printf("You now have $%d\n", budget);
			System.out.println("Play again?");
			decision = sc.nextLine();
			if(decision.equals("no")) {
				break;
			} else {
				dealerHand.resetHand();
				myHand.resetHand();
				deck.resetDeck();
			}
		}
		System.out.printf("Thanks for playing, you finished with $%d\n", budget);
		sc.close();
	}
}
