package ch15_2420;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class PickFourCards extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a VBox 
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(5, 5, 5, 5));

        // Create a HBox
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(5, 5, 5, 5));
        getCards(hBox);

        // Create a button
        Button btRefresh = new Button("Refresh");

        // Process events
        btRefresh.setOnAction(e -> getCards(hBox));

        // Place nodes in vbox
        vBox.getChildren().addAll(hBox, btRefresh);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("PickFourCards"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Returns a list with numbers 1-52 stored in random order
     */
    private void getCards(HBox pane) {
        pane.getChildren().clear();
        // Create a deck of card
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 2; i < 9; i++) {
            cards.add(i + 1);
        }

        // shuffle deck
        java.util.Collections.shuffle(cards);

        // Add nodes to pane
        for (int i = 0; i < 4; i++) {
            pane.getChildren().add(new ImageView(new Image( "ch15_2420//" + cards.get(i+2) +"C.png")));
        }
    }
}
