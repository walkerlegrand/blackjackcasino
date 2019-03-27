package com.java.blackjack;

public class Card {

	Card() {
	}; // default constructor

	// Assigns card a suit from numerical value generated (1-4)
	Card(int s, int numb) {
		if (s == 0) {
			setSuit("Hearts");
		} else if (s == 1) {
			setSuit("Spades");
		} else if (s == 2) {
			setSuit("Diamonds");
		} else {
			setSuit("Clubs");
		}

		// Assign card a face value and string to identify it
		switch (numb) {
		case 0:
			setAce(true);
			setValue(11);
			setNum("Ace of ");
			break;
		case 1:
			setNum("2 of ");
			setValue(2);
			break;
		case 2:
			setNum("3 of ");
			setValue(3);
			break;
		case 3:
			setNum("4 of ");
			setValue(4);
			break;
		case 4:
			setNum("5 of ");
			setValue(5);
			break;
		case 5:
			setNum("6 of ");
			setValue(6);
			break;
		case 6:
			setNum("7 of ");
			setValue(7);
			break;
		case 7:
			setNum("8 of ");
			setValue(8);
			break;
		case 8:
			setNum("9 of ");
			setValue(9);
			break;
		case 9:
			setNum("10 of ");
			setValue(10);
			break;
		case 10:
			setNum("Jack of ");
			setValue(10);
			break;
		case 11:
			setNum("Queen of ");
			setValue(10);
			break;
		case 12:
			setNum("King of ");
			setValue(10);
			break;
		}
	}
	
	// Values to uniquely identify each card
	private String suit;
	private String num;
	private int value;
	private boolean ace = false;

	// Set/get methods
	public boolean getAce() {
		return ace;
	}

	public void setAce(boolean ace) {
		this.ace = ace;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
