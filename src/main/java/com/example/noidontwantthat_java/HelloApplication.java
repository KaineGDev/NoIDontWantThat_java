package com.example.noidontwantthat_java;

import com.example.noidontwantthat_java.controller.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloApplication extends Application {
    HelloController controller = new HelloController();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Button für Neue Tätigkeiten
        Button newtask = new Button("Neue Tätigkeit anlegen");
        newtask.setOnAction(e -> {
            // Öffnen
            controller.handleNewTask(null);
        });

        // Button für Tätigkeit einsehen
        Button viewtask = new Button("Tätigkeiten einsehen");
        viewtask.setOnAction(e -> {
            // Einsehen
            controller.handleViewTask(null);
        });

        VBox layout = new VBox(10); // 10px Abstand zw Buttons
        layout.getChildren().addAll(newtask, viewtask);

        // Szene und Fenster
        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Tätigkeits-Manager!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}