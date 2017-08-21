package com.libertymutual.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.blackjack.model.Dealer;
import com.libertymutual.blackjack.model.Player;

@Controller
@RequestMapping(value={"/", "/blackjack"})
public class BlackjackController {

	private Player player;
	private Dealer dealer;
	private int currentBet;
	private String whoWins;
	
	public BlackjackController() {
		player = new Player();
		dealer = new Dealer();
		whoWins = "No winner!";
	}

	@GetMapping("/")
	public String game(Model model) {
		if (player.isBust()) {
			dealer.dealCardToSelf(); //maybe delete this 
			whoWins = "Dealer wins!";
			currentBet = 0;
		}
		model.addAttribute("player", player);
		model.addAttribute("dealer", dealer);
		model.addAttribute("currentBet", currentBet);
		model.addAttribute("winner", whoWins);
		model.addAttribute("canShowBetButton", currentBet == 0);
		model.addAttribute("canShowHitStand", currentBet != 0);
		return "/blackjack/game";
	}
	
	@PostMapping("bet")
	public String bet(int bet) {
		whoWins = "No winner!";
		currentBet = player.ante(bet);
		dealer.startRound();
		dealer.dealCardToPlayer(player);
		dealer.dealCardToSelf();
		dealer.dealCardToPlayer(player);
		return "redirect:/";
	}
	
	@PostMapping("hit")
	public String hit() {
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(player);
		return "redirect:/";
	}
	
	@PostMapping("stand")
	public String stand() {
		dealer.dealCardToSelf();
		dealer.finishRound();
		if (dealer.isBust()) {
			player.payout(currentBet * 2);
			whoWins = "Player wins!";
		} else if (player.hasBlackjack() && !dealer.hasBlackjack()) {
			player.payout(currentBet + currentBet / 2);
			whoWins = "Player wins!";
		} else if (dealer.hasBlackjack() && !player.hasBlackjack()) {
			whoWins = "Dealer wins!";
		} else if (player.getBestScore() == dealer.getBestScore()) {
			player.payout(currentBet);
			whoWins = "Tie!";
		} else if (player.getBestScore() > dealer.getBestScore()) {
			player.payout(currentBet * 2);
			whoWins = "Player wins!";
		} else if (dealer.getBestScore() > player.getBestScore()) {
			whoWins = "Dealer wins!";
		}
		currentBet = 0;
		return "redirect:/";
	}	
	
	@PostMapping("startover")
	public String startFresh() {
		player = new Player();
		dealer = new Dealer();
		whoWins = "No winner!";
		return "redirect:/";
	}
	
}
