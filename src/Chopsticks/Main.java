/**
 * <h1> Main </h1>
 * The Main class is where the stage and scenes will be set by invoking the
 * FXML loader which will read the StartingMenu.fxml file to build the scene graph, and
 * inject all the objects and methods in controller class.
 * @author Daniel Ramirez, Jennifer Mondragon, Ryan Cardin
 * @version 1.0
 * @since 2019-11-24
 */

package Chopsticks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartingMenu.fxml"));
        primaryStage.setTitle("Chopsticks");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //The application now launches in main.
    public static void main(String[] args) {
        launch(args);
    }
}
