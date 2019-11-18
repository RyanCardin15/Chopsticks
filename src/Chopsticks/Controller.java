package Chopsticks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {
    @FXML
    private ImageView image1,image2,image3,image4; //image1 and image2 are the top hands, and
    @FXML                                          // image3 and image4 are the bottom hand.
    private Button attack, split;
    @FXML
    private CheckBox topL,topR,bottomL,bottomR;     //top is player 2, and bottom is player1
    @FXML
    private TextArea textArea;      //action taken is displayed in the textArea.
    @FXML
    private Label player;   //Active player.

    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn=0;

    public void attackAction() {
        //I am thinking of using the images as what they want to attack with.
        if (topL.isSelected() && bottomL.isSelected()) {
            if ((turn%2) == 0)
            image1.setImage(new Image("/Hands/2.jpg"));

            topL.setSelected(false);
            bottomL.setSelected(false);     //This is to deselect the checkboxes.
        }
        else if (topL.isSelected() && bottomR.isSelected()) {
            image3.setImage(new Image("/Hands/3.jpg"));

            topL.setSelected(false);
            bottomR.setSelected(false);
        }
        else if (topR.isSelected() && bottomL.isSelected()) {
            image2.setImage(new Image("/Hands/4.jpg"));

            topR.setSelected(false);
            bottomL.setSelected(false);
        }
        else if (topR.isSelected() && bottomR.isSelected()) {
            image4.setImage(new Image("/Hands/5.jpg"));

            topR.setSelected(false);
            bottomR.setSelected(false);
        }
    }

    public void changeImage() {
        image1.setImage(new Image("/Hands/3.jpg"));
    }

}
