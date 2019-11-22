/**
 * For single player
 * Ryan
 */
package Chopsticks;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

import java.util.Random;


public class SinglePlayer extends Chopsticks {

    public void turnChange() {
        if (player1.isFinished() || player2.isFinished()) {
            gameWinner();
        }
        else {
            turn++;
            if ((turn % 2) == 0) {
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nComputer's Turn!!\n");
                player.setText("** Computer **");
                player.setTextFill(Paint.valueOf("Red"));
                computerhit();

            } else {
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nPlayer: 1's Turn!!\n");
                player.setText("** Player: 1 **");
                player.setTextFill(Paint.valueOf("Blue"));
            }
        }
    }

    @FXML
    public void btnHitLeft_click(){

            if (bottomL.isSelected() && !bottomR.isSelected()) {
                System.out.println("\nLEFT Computers old value: "+player2.getHand(0));
                player2.increaseHand((player1.getHand(0)), 0);
                System.out.println("\nLEFT Computers new value: "+player2.getHand(0));
                actionTaken.appendText("Player 1's LEFT hand hit the Computer's LEFT hand\n");
                bottomL.setSelected(false);
            } else if (bottomR.isSelected() && !bottomL.isSelected()) {
                System.out.println("\nLEFT Computers old value: "+player2.getHand(1));
                player2.increaseHand((player1.getHand(1)), 0);
                System.out.println("\nLEFT Computers new value: "+player2.getHand(1));
                actionTaken.appendText("Player 1's RIGHT hand hit the Computer's LEFT hand\n");
                bottomR.setSelected(false);
            } else if (bottomL.isSelected() && bottomR.isSelected()) {
                actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            } else
                actionTaken.appendText("Player 1 passes\n");

            if (player2.isOut(0)) {
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
                actionTaken.appendText("That hand has been destroyed\n");
            }
        turnChange();
    }

    @FXML
    public void btnHitRight_click(){

            if (bottomL.isSelected() && !bottomR.isSelected()) {
                player2.increaseHand((player1.getHand(0)), 1);
                actionTaken.appendText("Player 1's LEFT hand hit the Computer's Right hand\n");
                bottomL.setSelected(false);
            } else if (bottomR.isSelected() && !bottomL.isSelected()) {
                player2.increaseHand((player1.getHand(1)), 1);
                actionTaken.appendText("Player 1's RIGHT hand hit the Computer's Right hand\n");
                bottomR.setSelected(false);
            } else if (bottomL.isSelected() && bottomR.isSelected()) {
                actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            } else
                actionTaken.appendText("Player 1 passes\n");

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
            actionTaken.appendText("That hand has been destroyed\n");
        }
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
            actionTaken.appendText("The Computer has split their fingers up evenly!\n");
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


    public void computerhit(){
        Random rand = new Random();
        int randhit = rand.nextInt(9) % 2;
        int randhitfrom = rand.nextInt(9) % 2;
        int splitOrNot = rand.nextInt(4);


        if(splitOrNot == 0)
        {
            splitting();
        }
        else {
            if (player1.isOut(0) && player1.isOut(1))//if player 1 has both hands active
            {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has both hands active and computer has both hands active
                {
                    //computer hits player 1's random hand with its random hand
                    player1.increaseHand(player2.getHand(randhitfrom), randhit);
                    actionTaken.appendText("Computers " + nameCheck(randhitfrom) + " hand  hit Player 1's " + nameCheck(randhit) + " hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has both hand active and computer has only left hand
                {
                    //computer hits player 1's random hands with its left hand
                    player1.increaseHand(player2.getHand(0), randhit);
                    actionTaken.appendText("Computers left hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has both hand active and computer has only right hand
                {
                    //computer hits player 1's random hand with its right hand
                    player1.increaseHand(player2.getHand(1), randhit);
                    actionTaken.appendText("Computers right hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                }
            } else if (!player1.isOut(0) && player1.isOut(1))//if player 1 has only its left hand active
            {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has right hand only and computer has both hands active
                {
                    //computer hits player 1's right hand with its random hand
                    player1.increaseHand(player2.getHand(randhitfrom), 1);
                    actionTaken.appendText("Computers " + nameCheck(randhitfrom) + " hand hit Player 1's right hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has right hand only and computer has only left hand
                {
                    //computer hits player 1's right hands with its left hand
                    player1.increaseHand(player2.getHand(0), 1);
                    actionTaken.appendText("Computers left hand hit Player 1's right hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has right hand only and computer has only right hand
                {
                    //computer hits player 1's right hand with its right hand
                    player1.increaseHand(player2.getHand(1), 1);
                    actionTaken.appendText("Computers right hand hit Player 1's right hand\n");
                }
            } else if (player1.isOut(0) && !player1.isOut(1)) {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has left hand only and computer has both hands active
                {
                    //computer hits player 1's left hand with its random hand
                    player1.increaseHand(player2.getHand(randhitfrom), 0);
                    actionTaken.appendText("Computers " + nameCheck(randhitfrom) + " hand hit Player 1's left hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has left hand only and computer has only left hand
                {
                    //computer hits player 1's left hands with its left hand
                    player1.increaseHand(player2.getHand(0), 0);
                    actionTaken.appendText("Computer left hand hit Player 1's left hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has left hand only and computer has only right hand
                {
                    //computer hits player 1's left hand with its right hand
                    player1.increaseHand(player2.getHand(1), 0);
                    actionTaken.appendText("Computers right hand hit Player 1's left hand\n");
                }
            }
        }

        if (player1.isOut(0)) {
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
        } else {
            p1Left.setImage(new Image("/Hands/Left0.jpg"));
            actionTaken.appendText("That hand has been destroyed\n");
        }

        if (player1.isOut(1)) {
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
        } else {
            p1Right.setImage(new Image("/Hands/Right0.jpg"));
            actionTaken.appendText("That hand has been destroyed\n");
        }
        turnChange();
    }

    public String nameCheck(int a){
        if(a == 0)
        {
            return "left";
        }
        else
            return "right";
    }

    
    public void gameWinner() {
        if (player1.isFinished()) {
            actionTaken.appendText("The Computer is the winner!!");
            player.setText("**Computer is the winner!! **");
            player.setTextFill(Paint.valueOf("Red"));
            bottomL.setDisable(true);
            bottomR.setDisable(true);
            attackL.setDisable(true);
            attackR.setDisable(true);
            split.setDisable(true);
        }
        else if(player2.isFinished()) {
            actionTaken.appendText("Player 1 is the winner!!");
            player.setText("** Player: 1 is the winner!! **");
            player.setTextFill(Paint.valueOf("Blue"));
            bottomL.setDisable(true);
            bottomR.setDisable(true);
            attackL.setDisable(true);
            attackR.setDisable(true);
            split.setDisable(true);
        }
    }
}
