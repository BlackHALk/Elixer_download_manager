package Elixer_download_manager;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    Button dwlBtn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("download_manager.fxml"));
        primaryStage.setTitle("Download Manager");
        primaryStage.setScene(new Scene(root, 780, 575));
        primaryStage.setResizable(false);
        primaryStage.show();


    }



    public static void main(String[] args) {

        launch(args);
    }
}
