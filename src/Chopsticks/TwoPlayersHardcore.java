/**
 * <h1> TwoPLayersHardcore </h1>
 * The TwoPlayersHardcore class is a child controller class extended from the Chopsticks class. This class is the
 * controller class to the TwoPlayersHardcore.fxml which handles all the buttons events that are in this game mode.
 * This is the HARDCORE game mode which the player chooses to in the starting menu.
 * @author Daniel Ramirez, Jennifer Mondragon, Ryan Cardin
 * @version 1.0
 * @since 2019-11-24
 */

package Chopsticks;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;


public class TwoPlayersHardcore extends Chopsticks {

    @Override
    public void turnChange() {

        if (player1.hasLost() || player2.hasLost()) {   //Displays the winner
            gameWinner();
        }
        else {
            turn++;
            if ((turn % 2) == 0) {      //player 2's turn
                topL.setDisable(false);     //enable the player 2's checkboxes
                topR.setDisable(false);
                bottomL.setDisable(true);   //disable the player 1's checkboxes
                bottomR.setDisable(true);
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nPlayer: 2's Turn!!\n");
                player.setText("** Player: 2 **");                      //change the label to player 2.
                player.setTextFill(Paint.valueOf("Red"));

            } else {                //player 1's turn
                topL.setDisable(true);      //disable the player 2's checkboxes
                topR.setDisable(true);
                bottomL.setDisable(false);  //enable the player 1's checkboxes
                bottomR.setDisable(false);
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nPlayer: 1's Turn!!\n");
                player.setText("** Player: 1 **");                      //change the label to player 1.
                player.setTextFill(Paint.valueOf("Blue"));
            }
        }
    }

    @Override
    public void btnHitLeft_click(){

        if ((turn%2)==0) { //player 2's turn
            if (topL.isSelected() && !topR.isSelected()) {
                player1.increaseHardcore((player2.getHand(0)), 0);
                actionTaken.appendText("Player 2's LEFT hand hit Player 1's LEFT hand\n");
                topL.setSelected(false);            //deselect the checkbox
            }
            else if (topR.isSelected() && !topL.isSelected()) {
                player1.increaseHardcore((player2.getHand(1)), 0);
                actionTaken.appendText("Player 2's RIGHT hand hit Player 1's LEFT hand\n");
                topR.setSelected(false);            //deselect the checkbox
            }
            else if (topL.isSelected() && topR.isSelected()) {
                actionTaken.appendText("Player 2 what are you doing?? Next turn!\n");
                topL.setSelected(false);            //deselect the checkboxes
                topR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 2 passes\n");

            if(player1.isOut(0)) {
                switch (player1.getHand(0)) {       //updates the hand image.
                    case 1:
                        p1Left.setImage(new Image("/Hands/Left1.jpg"));
                        break;
                    case 2:
                        p1Left.setImage(new Image("/Hands/Left2.jpg"));
                        break;
                    case 3:
                        p1Left.setImage(new Image("/Hands/Left3.jpg"));
                        break;
                    case 4:
                        p1Left.setImage(new Image("/Hands/Left4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                p1Left.setImage(new Image("/Hands/Left0.jpg"));
                actionTaken.appendText("This hand has been destroyed\n");
            }
        }
        else {  //player 1's turn
            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHardcore((player1.getHand(0)), 0);
                actionTaken.appendText("Player 1's LEFT hand hit Player 2's LEFT hand\n");
                bottomL.setSelected(false);         //deselect the checkbox
            }
            else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHardcore((player1.getHand(1)), 0);
                actionTaken.appendText("Player 1's RIGHT hand hit Player 2's LEFT hand\n");
                bottomR.setSelected(false);          //deselect the checkbox
            }
            else if (bottomL.isSelected() && bottomR.isSelected()) {
                actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);          //deselect the checkboxes
                bottomR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 1 passes\n");

            if(player2.isOut(0)) {              //updates the hand image.
                switch (player2.getHand(0)) {
                    case 1:
                        p2Left.setImage(new Image("/Hands/Right1.jpg"));
                        break;
                    case 2:
                        p2Left.setImage(new Image("/Hands/Right2.jpg"));
                        break;
                    case 3:
                        p2Left.setImage(new Image("/Hands/Right3.jpg"));
                        break;
                    case 4:
                        p2Left.setImage(new Image("/Hands/Right4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                p2Left.setImage(new Image("/Hands/Right0.jpg"));
                actionTaken.appendText("This hand has been destroyed\n");
            }
        }
        turnChange();       //end of turn.
    }

    @Override
    public void btnHitRight_click(){

        if ((turn%2)==0) {  //Player 2's turn
            if (topL.isSelected() && !topR.isSelected()) {
                player1.increaseHardcore((player2.getHand(0)), 1);
                actionTaken.appendText("Player 2's LEFT hand hit Player 1's RIGHT hand\n");
                topL.setSelected(false);            //deselect the checkbox
            }
            else if (topR.isSelected() && !topL.isSelected()) {
                player1.increaseHardcore((player2.getHand(1)), 1);
                actionTaken.appendText("Player 2's RIGHT hand hit Player 1's RIGHT hand\n");
                topR.setSelected(false);        //deselect the checkbox
            }
            else if (topL.isSelected() && topR.isSelected()){
                actionTaken.appendText("Player 2 what are you doing?? Next turn!\n");
                topL.setSelected(false);        //deselect the checkboxes
                topR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 2 passes\n");

            if(player1.isOut(1)) {              //updates the hand image.
                switch (player1.getHand(1)) {
                    case 1:
                        p1Right.setImage(new Image("/Hands/Right1.jpg"));
                        break;
                    case 2:
                        p1Right.setImage(new Image("/Hands/Right2.jpg"));
                        break;
                    case 3:
                        p1Right.setImage(new Image("/Hands/Right3.jpg"));
                        break;
                    case 4:
                        p1Right.setImage(new Image("/Hands/Right4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                p1Right.setImage(new Image("/Hands/Right0.jpg"));
                actionTaken.appendText("This hand has been destroyed\n");
            }
        }
        else {      //Player 1's turn
            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHardcore((player1.getHand(0)), 1);
                actionTaken.appendText("Player 1's LEFT hand hit Player 2's RIGHT hand\n");
                bottomL.setSelected(false);         //deselect the checkbox
            }
            else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHardcore((player1.getHand(1)), 1);
                actionTaken.appendText("Player 1's RIGHT hand hit Player 2's RIGHT hand\n");
                bottomR.setSelected(false);         //deselect the checkbox
            }
            else if (bottomL.isSelected() && bottomR.isSelected()) {
                actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);         //deselect the checkboxes
                bottomR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 2 passes\n");

            if(player2.isOut(1)) {            //updates the hand image.
                switch (player2.getHand(1)) {
                    case 1:
                        p2Right.setImage(new Image("/Hands/Left1.jpg"));
                        break;
                    case 2:
                        p2Right.setImage(new Image("/Hands/Left2.jpg"));
                        break;
                    case 3:
                        p2Right.setImage(new Image("/Hands/Left3.jpg"));
                        break;
                    case 4:
                        p2Right.setImage(new Image("/Hands/Left4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                p2Right.setImage(new Image("/Hands/Left0.jpg"));
                actionTaken.appendText("This hand has been destroyed\n");
            }
        }
        turnChange();           //end of turn.
    }

    @Override
    public void splitting() {
        if ((turn%2) == 0) {        //Player 2's turn
            player2.splitFingers();     //split the fingers
            switch (player2.getHand(0)) {       //update the hand image.d
                case 1:
                    p2Left.setImage(new Image("/Hands/Right1.jpg"));
                    break;
                case 2:
                    p2Left.setImage(new Image("/Hands/Right2.jpg"));
                    break;
                case 3:
                    p2Left.setImage(new Image("/Hands/Right3.jpg"));
                    break;
                case 4:
                    p2Left.setImage(new Image("/Hands/Right4.jpg"));
                    break;
                default:
                    break;
            }
            switch (player2.getHand(1)) {
                case 1:
                    p2Right.setImage(new Image("/Hands/Left1.jpg"));
                    break;
                case 2:
                    p2Right.setImage(new Image("/Hands/Left2.jpg"));
                    break;
                case 3:
                    p2Right.setImage(new Image("/Hands/Left3.jpg"));
                    break;
                case 4:
                    p2Right.setImage(new Image("/Hands/Left4.jpg"));
                    break;
                default:
                    break;
            }
            actionTaken.appendText("Player 2 has split their fingers up evenly!\n");
        }
        else {          //Player 1's turn
            player1.splitFingers();     //spit the fingers up.
            switch (player1.getHand(0)) {       //update the hand image.
                case 1:
                    p1Left.setImage(new Image("/Hands/Left1.jpg"));
                    break;
                case 2:
                    p1Left.setImage(new Image("/Hands/Left2.jpg"));
                    break;
                case 3:
                    p1Left.setImage(new Image("/Hands/Left3.jpg"));
                    break;
                case 4:
                    p1Left.setImage(new Image("/Hands/Left4.jpg"));
                    break;
                default:
                    break;
            }
            switch (player1.getHand(1)) {
                case 1:
                    p1Right.setImage(new Image("/Hands/Right1.jpg"));
                    break;
                case 2:
                    p1Right.setImage(new Image("/Hands/Right2.jpg"));
                    break;
                case 3:
                    p1Right.setImage(new Image("/Hands/Right3.jpg"));
                    break;
                case 4:
                    p1Right.setImage(new Image("/Hands/Right4.jpg"));
                    break;
                default:
                    break;
            }
            actionTaken.appendText("Player 1 has split their fingers up evenly!\n");
        }
        turnChange();           //end of turn.
    }

    @Override
    public void gameWinner() {
        if (player1.hasLost()) {        //Display the winner.
            actionTaken.appendText("Player 2 is the winner!!");
            player.setText("** Player: 2 is the winner!! **");
            player.setTextFill(Paint.valueOf("Red"));
        }
        else if(player2.hasLost()) {
            actionTaken.appendText("Player 1 is the winner!!");
            player.setText("** Player: 1 is the winner!! **");
            player.setTextFill(Paint.valueOf("Blue"));
        }
        topL.setDisable(true);      //Disable all checkboxes and buttons.
        topR.setDisable(true);
        bottomL.setDisable(true);
        bottomR.setDisable(true);
        attackL.setDisable(true);
        attackR.setDisable(true);
        split.setDisable(true);
    }

    @Override
    public void restMenu() {
        super.restMenu();
    }
}
