/**
 * <h1> StartingMenu </h1>
 * The StartingMenu class is the starting menu that is use to pick which game mode the user wants to or read the rules
 * of the game. The is a clickable link if they wish to know more information on Chopsticks.
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
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class StartingMenu {
    @FXML
    private CheckBox onePlayer,twoPlayer;   //Theses are the checkbox on the which mode the user wants to play in.
    @FXML
    private Button traditional, hardcore, rules, backMenu, info;    //These are the buttons to launch a game mode, or rule page.

    /**
     * This method change the stage of  what ever that is being launched.
     * @param b Button The button that is being pressed.
     * @param fxml  String The FXML file that is being used.
     */
    public void change_page(Button b, String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage)b.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } catch (IOException e) {       //Throws an exception if the FXML file does not exist.
            e.printStackTrace();
        }
    }

    /**
     * This method is used when one of the game mode buttons are pushed. It calls
     * the change_page() method.
     */
    public void startGame() {

        if (onePlayer.isSelected() && !twoPlayer.isSelected()) {     //If the singleplayer mode is selected
            if (traditional.isPressed()) {
                change_page(traditional, "SinglePlayer.fxml");
            }
            else if (hardcore.isPressed()) {
                change_page(hardcore, "SinglePlayerHardcore.fxml");
            }
        }
        else if (twoPlayer.isSelected() && !onePlayer.isSelected()) { //If the twoplayer mode is selected
            if (traditional.isPressed()) {
                change_page(traditional, "TwoPlayers.fxml");
            }
            else if (hardcore.isPressed()) {
                change_page(hardcore, "TwoPlayersHardcore.fxml");
            }
        }
    }

    /**
     * This method is used when the rules page button is pushed. It calls
     * the change_page() method.
     */
    public void rules() {
        change_page(rules,"Rules.fxml");
    }

    /**
     * This method is used when the back button is pushed in the rules page. It calls
     * the change_page() method.
     */
    public void backRules() {
        change_page(backMenu,"StartingMenu.fxml");
    }

    /**
     * This method is used when the link button is pushed in the rules page.
     */
    public void moreInfo() {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop(); //this will open the browser
            URI url = new URI("https://en.wikipedia.org/wiki/Chopsticks_(hand_game)");// with this URL
            desktop.browse(url);
        } catch (Exception e) {         //Throws an exception if the URL does not exist.
            e.printStackTrace();
        }
    }
}
