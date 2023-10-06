package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;


import net.bootsfaces.utils.FacesMessages;

@Named
@ViewScoped
public class NumberGuessBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int counter = 1;

    private int game = 1;

    private int target = 5;

    @Min(1)
    @Max(10)
    private int guess = 2;

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void submitGuess() {
        String summary = "Wrong guess:";
        String msg = "Guess #" + counter++;
        if (guess > target) {
            msg += " is to high.";
        } else if (guess < target) {
            msg += " is to small.";
        } else {
            msg += " is correct!";
            summary = "Congratulations!";
        }
        FacesMessages.info("@property(numberGuessBean.guess)", summary, msg);

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
