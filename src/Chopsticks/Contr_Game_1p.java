/**
 * For single player
 * Ryan Cardin
 */
package Chopsticks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;


public class Contr_Game_1p {
    @FXML
    private ImageView image1,image2,image3,image4; //image1 and image2 are the top hands, and
    @FXML                                          // image3 and image4 are the bottom hand.
    private Button attack, split;
    @FXML
    private Button bottomL,bottomR;     //top is player 2, and bottom is player1
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
        }
        else {
            player.setText("** Player: 1 **");
            player.setTextFill(Paint.valueOf("Blue"));
        }
    }

    @FXML
    public void btnHitLeft_click(){
        //To do: check and see if the user has two hands. If they do, ask which hand they would like to hit with. Then
        //use that hand to grab the value to pass as the first parameter in increaseValue(); If they only have one hand, hit with the remaining one

        player2.increaseHand(1,0);//the amount will later on come from which ever hand the player hit them with. For now its just for testing. Side = 0(left hand) Side = 1(right hand)

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
        }
        turnChange();
    }

    @FXML
    public void btnHitRight_click(){
        //To do: check and see if the user has two hands. If they do, ask which hand they would like to hit with. Then
        //use that hand to grab the value to pass as the first parameter in increaseValue(); If they only have one hand, hit with the remaining one

        player2.increaseHand(3,1);//the amount will later on come from which ever hand the player hit them with. For now its just for testing. Side = 0(left hand) Side = 1(right hand)

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
        }
    }
}
