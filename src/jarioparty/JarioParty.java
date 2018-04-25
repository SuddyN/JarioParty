package jarioparty;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JarioParty extends Application {

    @Override
    public void start(Stage primaryStage) {

        JarioPlayerGUI root = new JarioPlayerGUI();

        VBox displayBox = new VBox(200, root);

        Scene scene = new Scene(displayBox, 500, 200);

        primaryStage.setTitle("Jario Party Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
