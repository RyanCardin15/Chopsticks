/**
 * For two players
 */

package Chopsticks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;


public class Game_2p {
    @FXML
    private ImageView image1,image2,image3,image4; //image1 and image2 are the top hands, and
    @FXML                                          // image3 and image4 are the bottom hand.
    private Button attackL,attackR,split;
    @FXML
    private CheckBox topL,topR,bottomL,bottomR;     //top is player 2, and bottom is player1
    @FXML
    private TextArea textArea;      //action taken is displayed in the textArea.
    @FXML
    private Label player;   //Active player.

    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn=1;

    public void turnChange() {
        turn++;
        if ((turn%2)==0) {
            topL.setDisable(false);
            topR.setDisable(false);
            bottomL.setDisable(true);
            bottomR.setDisable(true);

            textArea.appendText("Turn: "+turn);
            textArea.appendText("\nPlayer: 2's Turn!!\n");
            player.setText("** Player: 2 **");
            player.setTextFill(Paint.valueOf("Red"));
        }
        else {
            topL.setDisable(true);
            topR.setDisable(true);
            bottomL.setDisable(false);
            bottomR.setDisable(false);


            textArea.appendText("Turn: "+turn);
            textArea.appendText("\nPlayer: 1's Turn!!\n");
            player.setText("** Player: 1 **");
            player.setTextFill(Paint.valueOf("Blue"));
        }
    }

    @FXML
    public void btnHitLeft_click(){
        //To do: check and see if the user has two hands. If they do, ask which hand they would like to hit with. Then
        //use that hand to grab the value to pass as the first parameter in increaseValue(); If they only have one hand, hit with the remaining one


        if ((turn%2)==0) {
            if (topL.isSelected() && !topR.isSelected()) {
                player1.increaseHand((player2.getHand(0)), 0);
                textArea.appendText("Player 2's LEFT hand hit Player 1's LEFT hand\n");
                topL.setSelected(false);
            }
            else if (topR.isSelected() && !topL.isSelected()) {
                player1.increaseHand((player2.getHand(1)), 0);
                textArea.appendText("Player 2's RIGHT hand hit Player 1's LEFT hand\n");
                topR.setSelected(false);
            }
            else if (topL.isSelected() && topR.isSelected()) {
                textArea.appendText("Player 2 what are you doing?? Next turn!\n");
                topL.setSelected(false);
                topR.setSelected(false);
            }
            else
                textArea.appendText("Player 2 passes\n");

            if(player1.isOut(0)) {
                switch (player1.getHand(0)) {
                    case 1:
                        image3.setImage(new Image("/Hands/6.jpg"));
                        break;
                    case 2:
                        image3.setImage(new Image("/Hands/7.jpg"));
                        break;
                    case 3:
                        image3.setImage(new Image("/Hands/8.jpg"));
                        break;
                    case 4:
                        image3.setImage(new Image("/Hands/9.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                image3.setImage(new Image("/Hands/10.jpg"));
                textArea.appendText("This hand has been destroyed\n");
            }
        }
        else {
            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHand((player1.getHand(0)), 0);
                textArea.appendText("Player 1's LEFT hand hit Player 2's LEFT hand\n");
                bottomL.setSelected(false);
            }
            else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHand((player1.getHand(1)), 0);
                textArea.appendText("Player 1's RIGHT hand hit Player 2's LEFT hand\n");
                bottomR.setSelected(false);
            }
            else if (bottomL.isSelected() && bottomR.isSelected()) {
                textArea.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            }
            else
                textArea.appendText("Player 1 passes\n");

            if(player2.isOut(0)) {
                switch (player2.getHand(0)) {
                    case 1:
                        image1.setImage(new Image("/Hands/1.jpg"));
                        break;
                    case 2:
                        image1.setImage(new Image("/Hands/2.jpg"));
                        break;
                    case 3:
                        image1.setImage(new Image("/Hands/3.jpg"));
                        break;
                    case 4:
                        image1.setImage(new Image("/Hands/4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                image1.setImage(new Image("/Hands/5.jpg"));
                textArea.appendText("This hand has been destroyed\n");
            }
        }
        turnChange();
        gameWinner();
    }

    @FXML
    public void btnHitRight_click(){
        //To do: check and see if the user has two hands. If they do, ask which hand they would like to hit with. Then
        //use that hand to grab the value to pass as the first parameter in increaseValue(); If they only have one hand, hit with the remaining one

        if ((turn%2)==0) {
            if (topL.isSelected() && !topR.isSelected()) {
                player1.increaseHand((player2.getHand(0)), 1);
                textArea.appendText("Player 2's LEFT hand hit Player 1's RIGHT hand\n");
                topL.setSelected(false);
            }
            else if (topR.isSelected() && !topL.isSelected()) {
                player1.increaseHand((player2.getHand(1)), 1);
                textArea.appendText("Player 2's RIGHT hand hit Player 1's RIGHT hand\n");
                topR.setSelected(false);
            }
            else if (topL.isSelected() && topR.isSelected()){
                textArea.appendText("Player 2 what are you doing?? Next turn!\n");
                topL.setSelected(false);
                topR.setSelected(false);
            }
            else
                textArea.appendText("Player 2 passes\n");

            if(player1.isOut(1)) {
                switch (player1.getHand(1)) {
                    case 1:
                        image4.setImage(new Image("/Hands/1.jpg"));
                        break;
                    case 2:
                        image4.setImage(new Image("/Hands/2.jpg"));
                        break;
                    case 3:
                        image4.setImage(new Image("/Hands/3.jpg"));
                        break;
                    case 4:
                        image4.setImage(new Image("/Hands/4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                image4.setImage(new Image("/Hands/5.jpg"));
                textArea.appendText("This hand has been destroyed\n");
            }
        }
        else {
            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHand((player1.getHand(0)), 1);
                textArea.appendText("Player 1's LEFT hand hit Player 2's RIGHT hand\n");
                bottomL.setSelected(false);
            }
            else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHand((player1.getHand(1)), 1);
                textArea.appendText("Player 1's RIGHT hand hit Player 2's RIGHT hand\n");
                bottomR.setSelected(false);
            }
            else if (bottomL.isSelected() && bottomR.isSelected()) {
                textArea.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            }
            else
                textArea.appendText("Player 2 passes\n");

            if(player2.isOut(1)) {
                switch (player2.getHand(1)) {
                    case 1:
                        image2.setImage(new Image("/Hands/6.jpg"));
                        break;
                    case 2:
                        image2.setImage(new Image("/Hands/7.jpg"));
                        break;
                    case 3:
                        image2.setImage(new Image("/Hands/8.jpg"));
                        break;
                    case 4:
                        image2.setImage(new Image("/Hands/9.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                image2.setImage(new Image("/Hands/10.jpg"));
                textArea.appendText("This hand has been destroyed\n");
            }
        }
        turnChange();
        gameWinner();
    }

    public void splitting() {
        if ((turn%2) == 0) {
            player2.splitFingers();
            switch (player2.getHand(0)) {
                case 1:
                    image1.setImage(new Image("/Hands/1.jpg"));
                    break;
                case 2:
                    image1.setImage(new Image("/Hands/2.jpg"));
                    break;
                case 3:
                    image1.setImage(new Image("/Hands/3.jpg"));
                    break;
                case 4:
                    image1.setImage(new Image("/Hands/4.jpg"));
                    break;
                default:
                    break;
            }
            switch (player2.getHand(1)) {
                case 1:
                    image2.setImage(new Image("/Hands/6.jpg"));
                    break;
                case 2:
                    image2.setImage(new Image("/Hands/7.jpg"));
                    break;
                case 3:
                    image2.setImage(new Image("/Hands/8.jpg"));
                    break;
                case 4:
                    image2.setImage(new Image("/Hands/9.jpg"));
                    break;
                default:
                    break;
            }
                textArea.appendText("Player 2 has split their fingers up evenly!\n");
            }
            else {
                player1.splitFingers();
            switch (player1.getHand(0)) {
                case 1:
                    image3.setImage(new Image("/Hands/6.jpg"));
                    break;
                case 2:
                    image3.setImage(new Image("/Hands/7.jpg"));
                    break;
                case 3:
                    image3.setImage(new Image("/Hands/8.jpg"));
                    break;
                case 4:
                    image3.setImage(new Image("/Hands/9.jpg"));
                    break;
                default:
                    break;
            }
            switch (player1.getHand(1)) {
                case 1:
                    image4.setImage(new Image("/Hands/1.jpg"));
                    break;
                case 2:
                    image4.setImage(new Image("/Hands/2.jpg"));
                    break;
                case 3:
                    image4.setImage(new Image("/Hands/3.jpg"));
                    break;
                case 4:
                    image4.setImage(new Image("/Hands/4.jpg"));
                    break;
                default:
                    break;
            }
                textArea.appendText("Player 1 has split their fingers up evenly!\n");
            }
        turnChange();
    }

    public void gameWinner() {
        if (player1.isFinished()) {
            textArea.appendText("Player 2 is the winner!!");
            player.setText("** Player: 2 is the winner!! **");
            player.setTextFill(Paint.valueOf("Red"));
            topL.setDisable(true);
            topR.setDisable(true);
            bottomL.setDisable(true);
            bottomR.setDisable(true);
            attackL.setDisable(true);
            attackR.setDisable(true);
            split.setDisable(true);
        }
        else if(player2.isFinished()) {
            textArea.appendText("Player 1 is the winner!!");
            player.setText("** Player: 1 is the winner!! **");
            player.setTextFill(Paint.valueOf("Blue"));
            topL.setDisable(true);
            topR.setDisable(true);
            bottomL.setDisable(true);
            bottomR.setDisable(true);
            attackL.setDisable(true);
            attackR.setDisable(true);
            split.setDisable(true);
        }
    }
}
