/**
 * <h1> SinglePLayerHardcore </h1>
 * The SinglePLayerHardcore class is a child controller class extended from the Chopsticks class. This class is the
 * controller class to the SinglePLayerHardcore.fxml which handles all the buttons events that are in this game mode.
 * This is the HARDCORE game mode which the player chooses to in the starting menu.
 * @author Daniel Ramirez, Jennifer Mondragon, Ryan Cardin
 * @version 1.0
 * @since 2019-11-24
 */

package Chopsticks;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

import java.util.Random;


public class SinglePlayerHardcore extends Chopsticks {

    @Override
    public void turnChange() {
        if (player1.hasLost() || player2.hasLost()) {   //Displays the winner and player2 is the computer.
            gameWinner();
        }
        else {
            turn++;
            if ((turn % 2) == 0) {      //Player 2' turn
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nComputer's Turn!!\n");
                player.setText("** Computer **");           //change the label to Computer.
                player.setTextFill(Paint.valueOf("Red"));
                computerhit();                              //Call computer to make a move.

            } else {                    //player 1's turn
                actionTaken.appendText("Turn: " + turn);
                actionTaken.appendText("\nPlayer: 1's Turn!!\n");
                player.setText("** Player: 1 **");          //change the label to player 1.
                player.setTextFill(Paint.valueOf("Blue"));
            }
        }
    }

    @Override
    public void btnHitLeft_click(){
        //This will always be for player 1 only because player2 is the computer.
        if (bottomL.isSelected() && !bottomR.isSelected()) {    //if player 1 pick left hand to hit
            player2.increaseHardcore((player1.getHand(0)), 0);
            actionTaken.appendText("Player 1's LEFT hand hit the Computer's LEFT hand\n");
            bottomL.setSelected(false);             //deselect the checkbox
        } else if (bottomR.isSelected() && !bottomL.isSelected()) { //if player 1 pick right hand to hit
            player2.increaseHardcore((player1.getHand(1)), 0);
            actionTaken.appendText("Player 1's RIGHT hand hit the Computer's LEFT hand\n");
            bottomR.setSelected(false);             //deselect the checkbox
        } else if (bottomL.isSelected() && bottomR.isSelected()) {  //if player 1 pick both hands to hit
            actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
            bottomL.setSelected(false);             //deselect the checkboxes
            bottomR.setSelected(false);
        } else
            actionTaken.appendText("Player 1 passes\n");

        if (player2.isOut(0)) {
            switch (player2.getHand(0)) {           //updates the hand image.
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
        turnChange();       //end of turn.
    }

    @Override
    public void btnHitRight_click(){
        //This will always be for player 1 only because player2 is the computer.
        if (bottomL.isSelected() && !bottomR.isSelected()) {    //if player 1 pick left hand to hit
            player2.increaseHardcore((player1.getHand(0)), 1);
            actionTaken.appendText("Player 1's LEFT hand hit the Computer's Right hand\n");
            bottomL.setSelected(false);         //deselect the checkbox
        } else if (bottomR.isSelected() && !bottomL.isSelected()) { //if player 1 pick right hand to hit
            player2.increaseHardcore((player1.getHand(1)), 1);
            actionTaken.appendText("Player 1's RIGHT hand hit the Computer's Right hand\n");
            bottomR.setSelected(false);         //deselect the checkbox
        } else if (bottomL.isSelected() && bottomR.isSelected()) {  //if player 1 pick both hands to hit
            actionTaken.appendText("Player 1 what are you doing?? Next turn!\n");
            bottomL.setSelected(false);         //deselect the checkboxes
            bottomR.setSelected(false);
        } else
            actionTaken.appendText("Player 1 passes\n");

        if(player2.isOut(1)) {
            switch (player2.getHand(1)) {       //updates the hand image.
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
        turnChange();       //end of turn.
    }

    @Override
    public void splitting() {
        if ((turn%2) == 0) {    //Computer's turn
            player2.splitFingers(); //split the fingers
            switch (player2.getHand(0)) {       //update the hand image.
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
            switch (player2.getHand(1)) {       //update the hand image.
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
            switch (player1.getHand(1)) {   //update the hand image.
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
        turnChange();       //end of turn.
    }

    /**
     * This method is use to simulate a computer player hitting player 1's hands in the game.
     */
    public void computerhit(){
        Random rand = new Random();
        int randhit = rand.nextInt(2);   //The range of numbers is 0 - 1.
        int randhitfrom = rand.nextInt(2);  //The range of numbers is 0 - 1.
        int splitOrNot = rand.nextInt(4);   //The range of number is 0-3

        if(splitOrNot == 0 && player2.isOut(0) && player2.isOut(1))
        {
            splitting();    //splits the computers hands.
        }
        else {
            if (player1.isOut(0) && player1.isOut(1))//if player 1 has both hands active
            {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has both hands active and computer has both hands active
                {
                    //computer hits player 1's random hand with its random hand
                    player1.increaseHardcore(player2.getHand(randhitfrom), randhit);
                    actionTaken.appendText("Computers " + nameCheck(randhitfrom) + " hand  hit Player 1's " + nameCheck(randhit) + " hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has both hand active and computer has only left hand
                {
                    //computer hits player 1's random hands with its left hand
                    player1.increaseHardcore(player2.getHand(0), randhit);

                    actionTaken.appendText("Computers left hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                    //actionTaken.appendText("Computers left hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                    //textArea.appendText("This is the computers left value: " + player2.getHand(0));
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has both hand active and computer has only right hand
                {
                    //computer hits player 1's random hand with its right hand
                    player1.increaseHardcore(player2.getHand(1), randhit);
                    actionTaken.appendText("Computers right hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                }
            } else if (!player1.isOut(0) && player1.isOut(1))//if player 1 has only its left hand active
            {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has right hand only and computer has both hands active
                {
                    //computer hits player 1's right hand with its random hand
                    player1.increaseHardcore(player2.getHand(randhitfrom), 1);
                    actionTaken.appendText("Computers " + nameCheck(randhitfrom) + " hand hit Player 1's right hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has right hand only and computer has only left hand
                {
                    //computer hits player 1's right hands with its left hand
                    player1.increaseHardcore(player2.getHand(0), 1);
                    actionTaken.appendText("Computers left hand hit Player 1's right hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has right hand only and computer has only right hand
                {
                    //computer hits player 1's right hand with its right hand
                    player1.increaseHardcore(player2.getHand(1), 1);
                    actionTaken.appendText("Computers right hand hit Player 1's right hand\n");
                }
            } else if (player1.isOut(0) && !player1.isOut(1)) {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has left hand only and computer has both hands active
                {
                    //computer hits player 1's left hand with its random hand
                    player1.increaseHardcore(player2.getHand(randhitfrom), 0);
                    actionTaken.appendText("Computers " + nameCheck(randhitfrom) + " hand hit Player 1's left hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has left hand only and computer has only left hand
                {
                    //computer hits player 1's left hands with its left hand
                    player1.increaseHardcore(player2.getHand(0), 0);
                    actionTaken.appendText("Computer left hand hit Player 1's left hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has left hand only and computer has only right hand
                {
                    //computer hits player 1's left hand with its right hand
                    player1.increaseHardcore(player2.getHand(1), 0);
                    actionTaken.appendText("Computers right hand hit Player 1's left hand\n");
                }
            }
        }

        if (player1.isOut(0)) {
            switch (player1.getHand(0)) {           //update the hand image.
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

        if (player1.isOut(1)) {             //update the hand image.
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
        turnChange();       //end of turn.
    }

    /**
     * This method returns either its the left hand or right hand.
     * @param a int The hand that is being used.
     * @return String The hand that is being used.
     */
    public String nameCheck(int a){
        if(a == 0)
        {
            return "left";
        }
        else
            return "right";
    }

    @Override
    public void gameWinner() {
        if (player1.hasLost()) {    //Display the winner.
            actionTaken.appendText("The Computer is the winner!!");
            player.setText("**Computer is the winner!! **");
            player.setTextFill(Paint.valueOf("Red"));
        }
        else if(player2.hasLost()) {
            actionTaken.appendText("Player 1 is the winner!!");
            player.setText("** Player: 1 is the winner!! **");
            player.setTextFill(Paint.valueOf("Blue"));
        }
        bottomL.setDisable(true);        //Disable all checkboxes and buttons.
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

