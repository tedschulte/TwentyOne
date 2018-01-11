package com.lmig.gfc.twentyone.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.twentyone.models.Bank;
import com.lmig.gfc.twentyone.models.Card;
import com.lmig.gfc.twentyone.models.Deck;
import com.lmig.gfc.twentyone.models.Game;
import com.lmig.gfc.twentyone.models.Hand;

@Controller
public class TwentyOneControllers {

	private Game game;

	public TwentyOneControllers() {
		game = new Game();
	}

	@RequestMapping("/")
	public ModelAndView showBetScreen() {
		ModelAndView mv = new ModelAndView();

		if (game.getBankBalance() <= 0) {
			mv.setViewName("redirect:/gameover");
		} else {
			mv.setViewName("bet");
			mv.addObject("game", game);
		}
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {

		if (bet < 1) {
			bet = 1;
		}

		if (bet > game.getBankBalance()) {
			bet = game.getBankBalance();
		}

		boolean isInTheBlack = game.deal(bet);

		ModelAndView mv = new ModelAndView();
		if (isInTheBlack) {
			mv.setViewName("redirect:/play");
		} else {
			mv.setViewName("redirect:/gameover");
		}
		return mv;
	}
 
	@PostMapping("/stand")
	public ModelAndView dealerHit() {
		game.stand();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");
		return mv;
	} 
 
//	@RequestMapping("/result")
//	public ModelAndView showResultScreen() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		mv.addObject("game", game);
//		return mv;
//	}
	
	@GetMapping("/gameover")
	public ModelAndView showGameOver() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gameOver");
		return mv;
	}
  
	@RequestMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		mv.addObject("game", game);
		return mv;
	}

	@PostMapping("/hit")
	public ModelAndView handleHit() {
		game.hit();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");
		return mv;
	}

	@PostMapping("/reset")
	public ModelAndView handleBet() {
		game = new Game();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}

}
// Create a class
// Create a private ArrayList or Stack to hold Card object named "cards"
// In the constructor of Deck, make a foreach loop that loops over each suit
// (set up by mustache to check in view)
// for every suit, create an ace card and add it to the cards collection
