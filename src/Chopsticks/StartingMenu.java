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
    private CheckBox onePlayer,twoPlayer;
    @FXML
    private Button traditional, hardcore, rules, backMenu, info;

    public void change_page(Button b, String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage)b.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {

        if (onePlayer.isSelected() && !twoPlayer.isSelected()) {
            if (traditional.isPressed()) {
                change_page(traditional, "SinglePlayer.fxml");
            }
        }
        else if (twoPlayer.isSelected() && !onePlayer.isSelected()) {
            if (traditional.isPressed()) {
                change_page(traditional, "TwoPlayers.fxml");
            }
        }

        if (onePlayer.isSelected() && !twoPlayer.isSelected()) {
            if (hardcore.isPressed()) {
                change_page(hardcore, "SinglePlayerHardcore.fxml");
            }
        }
        else if (twoPlayer.isSelected() && !onePlayer.isSelected()) {
            if (hardcore.isPressed()) {
                change_page(hardcore, "TwoPlayersHardcore.fxml");
            }
        }
    }

    public void rules() {
        change_page(rules,"Rules.fxml");
    }

    public void backRules() {
        change_page(backMenu,"StartingMenu.fxml");
    }

    public void moreInfo() {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop(); //this will open the browser
            URI url = new URI("https://en.wikipedia.org/wiki/Chopsticks_(hand_game)");// with this URL
            desktop.browse(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
