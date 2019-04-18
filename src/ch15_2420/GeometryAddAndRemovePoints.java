/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch15_2420;

import javafx.application.Application;
import javafx.scene.input.MouseButton;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GeometryAddAndRemovePoints extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        // Create and register the handle
        pane.setOnMouseClicked(e -> {
            // Create a circle
            Circle circle = new Circle(e.getX(), e.getY(), 5);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            if (e.getButton() == MouseButton.PRIMARY) {
                pane.getChildren().add(circle);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                ObservableList<Node> list = pane.getChildren();
                for (int i = 0; i < list.size(); i++) {
                    Circle c = (Circle) list.get(i);
                    if (circle.contains(c.getCenterX(), c.getCenterY())) {
                        list.remove(i);
                    }
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("GeometryAddAndRemovePoints"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
