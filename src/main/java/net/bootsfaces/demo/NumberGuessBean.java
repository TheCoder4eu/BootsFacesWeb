package net.bootsfaces.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@ViewScoped
public class NumberGuessBean {

	private int counter = 1;

	private int game = 1;

	private int target=5;

	@Min(1)
	@Max(10)
	private int guess=42;

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public void submitGuess() {
		String msg = "Guess #" + counter++;
		if (guess > target) {
			msg += " is to high.";
		} else if (guess < target)
		{
			msg += " is to small.";
		} else {
			msg += " is correct!";
		}
		FacesMessages.info(msg);
	}

	public void newGame() {
		FacesMessages.info("Start game #" + game++ + ".");
	}

	public void clearMessages() {

	}

	public void startNewGame(ActionEvent event) {
		FacesMessages.info("Start game by actionListener #" + game++ + ".");
	}
}
