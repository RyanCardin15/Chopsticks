package Chopsticks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StartingMenu {
    @FXML
    private CheckBox onePlayer,twoPlayer;
    @FXML
    private Button traditional, Hardcore;

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
            if (Hardcore.isPressed()) {
                change_page(Hardcore, "SinglePlayerHardcore.fxml");
            }
        }
        else if (twoPlayer.isSelected() && !onePlayer.isSelected()) {
            if (Hardcore.isPressed()) {
                change_page(Hardcore, "TwoPlayersHardcore.fxml");
            }
        }


    }
}
