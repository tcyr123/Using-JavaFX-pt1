package ch15_2420;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RotateARectangle extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(90);
        rectangle.setHeight(40);
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLACK);

        // Create a button
        Button btRotate = new Button("Rotate");

        // Process events
        btRotate.setOnAction(e
                -> rectangle.setRotate(rectangle.getRotate() + 15));

        // Create a border pane and set its properties
        BorderPane pane = new BorderPane();
        pane.setCenter(rectangle);
        pane.setBottom(btRotate);
        BorderPane.setAlignment(rectangle, Pos.CENTER);
        BorderPane.setAlignment(btRotate, Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 170, 170);
        primaryStage.setTitle("RotateARectangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage; 
    }
    public static void main(String[] args) {
        launch(args);
    }
}
