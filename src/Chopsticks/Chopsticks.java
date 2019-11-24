/**
 * <h1> Chopsticks </h1>
 * The Chopsticks abstract class is the basic form of a FXML controller for each game mode
 * for the hand game called Chopsticks.
 * @author Daniel Ramirez, Jennifer Mondragon, Ryan Cardin
 * @version 1.0
 * @since 2019-11-24
 */

package Chopsticks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Chopsticks {
    @FXML
    protected ImageView p2Left,p2Right,p1Left,p1Right; //p2Left and p2Right are player 2's hands, and
    @FXML                                              //p1Left and p1Right are player 1's hands.
    protected Button attackL, attackR, split, BackMenu;
    @FXML
    protected CheckBox topL,topR,bottomL,bottomR;     //top is computer, and bottom is player1
    @FXML
    protected TextArea actionTaken;      //action taken is displayed in the textArea.
    @FXML
    protected Label player;   //Active player.

    protected Player player1 = new Player();
    protected Player player2 = new Player();
    protected int turn=1;

    /**
     * This abstract method is to indicate the change of turns for each player.
     */
    public abstract void turnChange();

    /**
     * This abstract method is for hitting the opponent left hand after indicating what hand
     * the player will hit with.
     */
    public abstract void btnHitLeft_click();

    /**
     * This abstract method is similar as btnHitLeft_click(), but it's for hitting the opponent
     * right hand after indicating what hand the player will hit with.
     */
    public abstract void btnHitRight_click();

    /**
     * This abstract method is for the action of splitting up the players fingers on each hand
     * evenly.
     */
    public abstract void splitting();

    /**
     * This abstract method is to indicate if a player has won or not.
     */
    public abstract void gameWinner();

    /**
     * This method is for restarting after the game has ended or just want to go back to the startingMenu.
     */
    public void restMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StartingMenu.fxml"));
            Stage stage = (Stage)BackMenu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
