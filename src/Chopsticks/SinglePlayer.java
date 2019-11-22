/**
 * For single player
 * Ryan
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

import java.util.Random;


public class Game_1p {
    @FXML
    private ImageView image1,image2,image3,image4; //image1 and image2 are the top hands, and
    @FXML                                          // image3 and image4 are the bottom hand.
    private Button attackL, attackR, split;
    @FXML
    private CheckBox bottomL,bottomR;     //top is player 2, and bottom is player1
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
            player.setText("** Computer **");
            player.setTextFill(Paint.valueOf("Red"));
            computerhit();
        }
        else {
            player.setText("** Player: 1 **");
            player.setTextFill(Paint.valueOf("Blue"));
        }
    }

    @FXML
    public void btnHitLeft_click(){

            if (bottomL.isSelected() && !bottomR.isSelected()) {
                System.out.println("\nLEFT Computers old value: "+player2.getHand(0));
                player2.increaseHand((player1.getHand(0)), 0);
                System.out.println("\nLEFT Computers new value: "+player2.getHand(0));
                textArea.appendText("Player 1's LEFT hand hit Player 2's LEFT hand\n");
                bottomL.setSelected(false);
            } else if (bottomR.isSelected() && !bottomL.isSelected()) {
                System.out.println("\nLEFT Computers old value: "+player2.getHand(0));
                player2.increaseHand((player1.getHand(1)), 0);
                System.out.println("\nLEFT Computers new value: "+player2.getHand(0));
                textArea.appendText("Player 1's RIGHT hand hit Player 2's LEFT hand\n");
                bottomR.setSelected(false);
            } else if (bottomL.isSelected() && bottomR.isSelected()) {
                textArea.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            } else
                textArea.appendText("Player 1 passes\n");

            if (player2.isOut(0)) {
                switch (player2.getHand(0)) {
                    case 1:
                        image1.setImage(new Image("/Hands/Right1.jpg"));
                        break;
                    case 2:
                        image1.setImage(new Image("/Hands/Right2.jpg"));
                        break;
                    case 3:
                        image1.setImage(new Image("/Hands/Right3.jpg"));
                        break;
                    case 4:
                        image1.setImage(new Image("/Hands/Right4.jpg"));
                        break;
                    default:
                        break;
                }
            }
            else {
                image1.setImage(new Image("/Hands/Right0.jpg"));
                textArea.appendText("This hand has been destroyed\n");
            }

        turnChange();
        gameWinner();
    }

    @FXML
    public void btnHitRight_click(){

            if (bottomL.isSelected() && !bottomR.isSelected()) {
                System.out.println("\nRIGHT Computers old value: "+player2.getHand(1));
                player2.increaseHand((player1.getHand(0)), 1);
                System.out.println("\nRIGHT Computers new value: "+player2.getHand(1));
                textArea.appendText("Player 1's LEFT hand hit Player 2's RIGHT hand\n");
                bottomL.setSelected(false);
            } else if (bottomR.isSelected() && !bottomL.isSelected()) {
                System.out.println("\nRIGHT Computers old value: "+player2.getHand(1));
                player2.increaseHand((player1.getHand(1)), 1);
                System.out.println("\nRIGHT Computers new value: "+player2.getHand(1));
                textArea.appendText("Player 1's RIGHT hand hit Player 2's RIGHT hand\n");
                bottomR.setSelected(false);
            } else if (bottomL.isSelected() && bottomR.isSelected()) {
                textArea.appendText("Player 1 what are you doing?? Next turn!\n");
                bottomL.setSelected(false);
                bottomR.setSelected(false);
            } else
                textArea.appendText("Player 1 passes\n");

        if(player2.isOut(1)) {
            switch (player2.getHand(1)) {
                case 1:
                    image2.setImage(new Image("/Hands/Left1.jpg"));
                    break;
                case 2:
                    image2.setImage(new Image("/Hands/Left2.jpg"));
                    break;
                case 3:
                    image2.setImage(new Image("/Hands/Left3.jpg"));
                    break;
                case 4:
                    image2.setImage(new Image("/Hands/Left4.jpg"));
                    break;
                default:
                    break;
            }
        }
        else {
            image2.setImage(new Image("/Hands/Left0.jpg"));
            textArea.appendText("This hand has been destroyed\n");
        }
        turnChange();
        gameWinner();
    }


    public void splitting() {
        if ((turn%2) == 0) {
            player2.splitFingers();
            switch (player2.getHand(0)) {
                case 1:
                    image1.setImage(new Image("/Hands/Right1.jpg"));
                    break;
                case 2:
                    image1.setImage(new Image("/Hands/Right2.jpg"));
                    break;
                case 3:
                    image1.setImage(new Image("/Hands/Right3.jpg"));
                    break;
                case 4:
                    image1.setImage(new Image("/Hands/Right4.jpg"));
                    break;
                default:
                    break;
            }
            switch (player2.getHand(1)) {
                case 1:
                    image2.setImage(new Image("/Hands/Left1.jpg"));
                    break;
                case 2:
                    image2.setImage(new Image("/Hands/Left2.jpg"));
                    break;
                case 3:
                    image2.setImage(new Image("/Hands/Left3.jpg"));
                    break;
                case 4:
                    image2.setImage(new Image("/Hands/Left4.jpg"));
                    break;
                default:
                    break;
            }
            textArea.appendText("The Computer has split their fingers up evenly!\n");
        }
        else {
            player1.splitFingers();
            switch (player1.getHand(0)) {
                case 1:
                    image3.setImage(new Image("/Hands/Left1.jpg"));
                    break;
                case 2:
                    image3.setImage(new Image("/Hands/Left2.jpg"));
                    break;
                case 3:
                    image3.setImage(new Image("/Hands/Left3.jpg"));
                    break;
                case 4:
                    image3.setImage(new Image("/Hands/Left4.jpg"));
                    break;
                default:
                    break;
            }
            switch (player1.getHand(1)) {
                case 1:
                    image4.setImage(new Image("/Hands/Right1.jpg"));
                    break;
                case 2:
                    image4.setImage(new Image("/Hands/Right2.jpg"));
                    break;
                case 3:
                    image4.setImage(new Image("/Hands/Right3.jpg"));
                    break;
                case 4:
                    image4.setImage(new Image("/Hands/Right4.jpg"));
                    break;
                default:
                    break;
            }
            textArea.appendText("Player 1 has split their fingers up evenly!\n");
        }
        turnChange();
    }






    public void computerhit(){
        Random rand = new Random();
        int randhit = rand.nextInt(9) % 2;
        int randhitfrom = rand.nextInt(9) % 2;
        int splitOrNot = rand.nextInt(4);


        if(splitOrNot == 0 && player2.isOut(0) && player2.isOut(1))
        {
            player2.splitFingers();
            textArea.appendText("Computer split fingers\n");
        }
        else {
            if (player1.isOut(0) && player1.isOut(1))//if player 1 has both hands active
            {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has both hands active and computer has both hands active
                {
                    //computer hits player 1's random hand with its random hand
                    player1.increaseHand(player2.getHand(randhitfrom), randhit);
                    textArea.appendText("Computers " + nameCheck(randhitfrom) + " hand  hit Player 1's " + nameCheck(randhit) + " hand\n");
                    //textArea.appendText("This is the computers " + nameCheck(randhitfrom) + " value: " + player2.getHand(randhitfrom));
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has both hand active and computer has only left hand
                {
                    //computer hits player 1's random hands with its left hand
                    player1.increaseHand(player2.getHand(0), randhit);
                    textArea.appendText("Computers left hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                    //textArea.appendText("This is the computers left value: " + player2.getHand(0));
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has both hand active and computer has only right hand
                {
                    //computer hits player 1's random hand with its right hand
                    player1.increaseHand(player2.getHand(1), randhit);
                    textArea.appendText("Computers right hand hit Player 1's " + nameCheck(randhit) + " hand\n");
                    //textArea.appendText("This is the computers right value: " + player2.getHand(1));
                }
            } else if (!player1.isOut(0) && player1.isOut(1))//if player 1 has only its left hand active
            {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has right hand only and computer has both hands active
                {
                    //computer hits player 1's right hand with its random hand
                    player1.increaseHand(player2.getHand(randhitfrom), 1);
                    textArea.appendText("Computers " + nameCheck(randhitfrom) + " hand hit Player 1's right hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has right hand only and computer has only left hand
                {
                    //computer hits player 1's right hands with its left hand
                    player1.increaseHand(player2.getHand(0), 1);
                    textArea.appendText("Computers left hand hit Player 1's right hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has right hand only and computer has only right hand
                {
                    //computer hits player 1's right hand with its right hand
                    player1.increaseHand(player2.getHand(1), 1);
                    textArea.appendText("Computers right hand hit Player 1's right hand\n");
                }
            } else if (player1.isOut(0) && !player1.isOut(1)) {
                if (player2.isOut(0) && player2.isOut(1))//if player 1 has left hand only and computer has both hands active
                {
                    //computer hits player 1's left hand with its random hand
                    player1.increaseHand(player2.getHand(randhitfrom), 0);
                    textArea.appendText("Computers " + nameCheck(randhitfrom) + " hand hit Player 1's left hand\n");
                } else if (player2.isOut(0) && !player2.isOut(1))//if player 1 has left hand only and computer has only left hand
                {
                    //computer hits player 1's left hands with its left hand
                    player1.increaseHand(player2.getHand(0), 0);
                    textArea.appendText("Computer left hand hit Player 1's left hand\n");
                } else if (!player2.isOut(0) && player2.isOut(1))//if player 1 has left hand only and computer has only right hand
                {
                    //computer hits player 1's left hand with its right hand
                    player1.increaseHand(player2.getHand(1), 0);
                    textArea.appendText("Computers right hand hit Player 1's left hand\n");
                }
            }
        }


        if (player1.isOut(0)) {
            switch (player1.getHand(0)) {
                case 1:
                    image3.setImage(new Image("/Hands/Left1.jpg"));
                    break;
                case 2:
                    image3.setImage(new Image("/Hands/Left2.jpg"));
                    break;
                case 3:
                    image3.setImage(new Image("/Hands/Left3.jpg"));
                    break;
                case 4:
                    image3.setImage(new Image("/Hands/Left4.jpg"));
                    break;
                default:
                    break;
            }
        } else {
            image3.setImage(new Image("/Hands/Left0.jpg"));
            textArea.appendText("This hand has been destroyed\n");
        }

        if (player1.isOut(1)) {
            switch (player1.getHand(1)) {
                case 1:
                    image4.setImage(new Image("/Hands/Right1.jpg"));
                    break;
                case 2:
                    image4.setImage(new Image("/Hands/Right2.jpg"));
                    break;
                case 3:
                    image4.setImage(new Image("/Hands/Right3.jpg"));
                    break;
                case 4:
                    image4.setImage(new Image("/Hands/Right4.jpg"));
                    break;
                default:
                    break;
            }
        } else {
            image4.setImage(new Image("/Hands/Right0.jpg"));
            textArea.appendText("This hand has been destroyed\n");
        }

        turnChange();
        gameWinner();
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
            textArea.appendText("The computer is the winner!!");
            player.setText("** The computer is the winner!! **");
            player.setTextFill(Paint.valueOf("Red"));
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
            bottomL.setDisable(true);
            bottomR.setDisable(true);
            attackL.setDisable(true);
            attackR.setDisable(true);
            split.setDisable(true);
        }
    }
}
