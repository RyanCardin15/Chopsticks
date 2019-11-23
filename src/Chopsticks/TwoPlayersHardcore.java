/**
 * For two players
 */

package Chopsticks;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;


public class TwoPlayersHardcore extends Chopsticks {

    public void turnChange() {

        if (player1.isFinished() || player2.isFinished()) {
            gameWinner();
        }
        else {
            turn++;
            if ((turn % 2) == 0) {
                topL.setDisable(false);
                topR.setDisable(false);
                bottomL.setDisable(true);
                bottomR.setDisable(true);
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nPlayer: 2's Turn!!\n");
                player.setText("** Player: 2 **");
                player.setTextFill(Paint.valueOf("Red"));

            } else {
                topL.setDisable(true);
                topR.setDisable(true);
                bottomL.setDisable(false);
                bottomR.setDisable(false);
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nPlayer: 1's Turn!!\n");
                player.setText("** Player: 1 **");
                player.setTextFill(Paint.valueOf("Blue"));
            }
        }
    }

    @FXML
    public void btnHitLeft_click(){

        if ((turn%2)==0) {
            if (topL.isSelected() && !topR.isSelected()) {
                player1.increaseHardcore((player2.getHand(0)), 0);
                actionTaken.appendText("Player 2's LEFT hand hit Player 1's LEFT hand\n");
                topL.setSelected(false);
            }
            else if (topR.isSelected() && !topL.isSelected()) {
                player1.increaseHardcore((player2.getHand(1)), 0);
                actionTaken.appendText("Player 2's RIGHT hand hit Player 1's LEFT hand\n");
                topR.setSelected(false);
            }
            else if (topL.isSelected() && topR.isSelected()) {
                actionTaken.appendText("Player 2 what are you doing?? Next turn!\n");
                topL.setSelected(false);
                topR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 2 passes\n");

            if(player1.isOut(0)) {
                switch (player1.getHand(0)) {
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
        else {
            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHardcore((player1.getHand(0)), 0);
                actionTaken.appendText("Player 1's LEFT hand hit Player 2's LEFT hand\n");
                bottomL.setSelected(false);
            }
            else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHardcore((player1.getHand(1)), 0);
                actionTaken.appendText("Player 1's RIGHT hand hit Player 2's LEFT hand\n");
                bottomR.setSelected(false);
            }
            else if (bottomL.isSelected() && bottomR.isSelected()) {
                actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 1 passes\n");

            if(player2.isOut(0)) {
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
        gameWinner();
        turnChange();
    }

    @FXML
    public void btnHitRight_click(){
        //To do: check and see if the user has two hands. If they do, ask which hand they would like to hit with. Then
        //use that hand to grab the value to pass as the first parameter in increaseValue(); If they only have one hand, hit with the remaining one

        if ((turn%2)==0) {
            if (topL.isSelected() && !topR.isSelected()) {
            player1.increaseHardcore((player2.getHand(0)), 1);
            actionTaken.appendText("Player 2's LEFT hand hit Player 1's RIGHT hand\n");
            topL.setSelected(false);
            }
            else if (topR.isSelected() && !topL.isSelected()) {
                player1.increaseHardcore((player2.getHand(1)), 1);
                actionTaken.appendText("Player 2's RIGHT hand hit Player 1's RIGHT hand\n");
                topR.setSelected(false);
            }
            else if (topL.isSelected() && topR.isSelected()){
                actionTaken.appendText("Player 2 what are you doing?? Next turn!\n");
                topL.setSelected(false);
                topR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 2 passes\n");

            if(player1.isOut(1)) {
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
        else {
            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHardcore((player1.getHand(0)), 1);
                actionTaken.appendText("Player 1's LEFT hand hit Player 2's RIGHT hand\n");
                bottomL.setSelected(false);
            }
            else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHardcore((player1.getHand(1)), 1);
                actionTaken.appendText("Player 1's RIGHT hand hit Player 2's RIGHT hand\n");
                bottomR.setSelected(false);
            }
            else if (bottomL.isSelected() && bottomR.isSelected()) {
                actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            }
            else
                actionTaken.appendText("Player 2 passes\n");

            if(player2.isOut(1)) {
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
        gameWinner();
        turnChange();
    }

    public void splitting() {
        if ((turn%2) == 0) {
            player2.splitFingers();
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
            else {
                player1.splitFingers();
            switch (player1.getHand(0)) {
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
        turnChange();
    }

    public void gameWinner() {
        if (player1.isFinished()) {
            actionTaken.appendText("Player 2 is the winner!!");
            player.setText("** Player: 2 is the winner!! **");
            player.setTextFill(Paint.valueOf("Red"));
        }
        else if(player2.isFinished()) {
            actionTaken.appendText("Player 1 is the winner!!");
            player.setText("** Player: 1 is the winner!! **");
            player.setTextFill(Paint.valueOf("Blue"));
        }
        topL.setDisable(true);
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
