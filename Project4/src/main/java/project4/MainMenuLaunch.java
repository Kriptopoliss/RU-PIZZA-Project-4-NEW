package project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainMenuLaunch extends Application {


    @Override
    public void start(Stage primaryStage) {
        try {

            // Load the main menu FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project4/MainMenu.fxml"));
            Parent root = loader.load();

            // Set the scene on the primary stage
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("RU Pizza");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
