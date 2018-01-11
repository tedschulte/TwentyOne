package com.lmig.gfc.twentyone.models;

import org.springframework.web.servlet.ModelAndView;

public class Game {

	Hand playerHand = new Hand();

	Hand dealerHand = new Hand();

	Deck deck = new Deck();

	Bank bank = new Bank();

	public Game() {

		this.playerHand = playerHand;

		this.dealerHand = dealerHand;

	}

	public boolean deal(int bet) {

		playerHand = new Hand();
		dealerHand = new Hand();

		boolean isInTheBlack = bank.setBalance(bank.getBalance() - bet);

		if (isInTheBlack) {
			Card card = deck.draw();
			playerHand.accept(card);
			card = deck.draw();
			playerHand.accept(card);
			card = deck.draw();
			dealerHand.accept(card);
			card = deck.draw();
			dealerHand.accept(card);
		}

		return isInTheBlack;
	}

	public void stand() {

		int i = dealerHand.getTotal();
 
		while (i < 17) {
			Card card = deck.draw();
			dealerHand.accept(card);
			i = dealerHand.getTotal() + card.getValue();
		}
 

		// mv.setViewName("redirect:/gameover") boolean here, or place in game logic???
		// need to remove "hit me" button once stand selected
		// dealer hand method if stand
		// dealer hand on while loop ???until bust, 16 or blackjack
		// final calculations for game logic to compare hands
		// replies for win, lose, or blackjack via mustache in html
		// play again/continue button to return ?
	}

	public int getBankBalance() {
		return bank.getBalance();
	}

	public void hit() {

		int i = playerHand.getTotal();

		while (i <= 21) {
			Card card = deck.draw();
			playerHand.accept(card);
			i = playerHand.getTotal() + card.getValue();
		}
		
//		int winner;
		
//		if (playerHand.getTotal() < 21) {
//			return (playerHand.getTotal() - dealerHand.getTotal());
		}
	}

	
	// player hand method first to track total until bust, blackjack or stand
	// refer to game over if bust; refer to dealer hand if stand or blackjack (2
	// cards and = 21)
		// mv.setViewName("redirect:/gameover") boolean here, or place in game logic???


