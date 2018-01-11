package com.lmig.gfc.twentyone.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		
		for (Suits suit : Suits.values()) {
			AceCard aceCard = new AceCard(suit);
			cards.add(aceCard);
		}

		for (Suits suit : Suits.values()) {
			for (int index = 2; index <= 10; index++) {
				NumberCard numberCard = new NumberCard(suit, index);
				cards.add(numberCard);
			}

		}

		for (Suits suit : Suits.values()) {
			for (Faces face : Faces.values()) {
				FaceCard faceCard = new FaceCard(suit, face);
				cards.add(faceCard);
			}

			// public <stack> deck) {
			// this.stack = deck;

			// add stack to utilize deck so cards can be popped and pushed from deck to
			// player and dealer hands
			// loop back to refresh play html
			// need game logic methods to determine results - bust, blackjack, and apply
			// player results, then dealer if needed
			// need to create shuffle method
		
		}
		Collections.shuffle(cards);
	}

	public Card draw() {
		// TODO Auto-generated method stub
		return cards.remove(0);
	}

}
