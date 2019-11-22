package Chopsticks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public abstract class Chopsticks {
    @FXML
    protected ImageView p2Left,p2Right,p1Left,p1Right; //p2Left and p2Right are player 2's hands, and
    @FXML                                            //p1Left and p1Right are player 1's hands.
    protected Button attackL, attackR, split;
    @FXML
    protected CheckBox topL,topR,bottomL,bottomR;     //top is computer, and bottom is player1
    @FXML
    protected TextArea actionTaken;      //action taken is displayed in the textArea.
    @FXML
    protected Label player;   //Active player.

    protected Player player1 = new Player();
    protected Player player2 = new Player();
    protected int turn=1;

    public abstract void turnChange();

    public abstract void btnHitLeft_click();

    public abstract void btnHitRight_click();

    public abstract void splitting();

    public abstract void gameWinner();
}
