package com.example.noidontwantthat_java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    //blabla
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void handleNewTask(ActionEvent event) {
        try {
            // FXML laden
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/noidontwantthat_java/new-task-view.fxml"));
            Parent root = fxmlLoader.load();

            // neue Szene (Fenster)
            Stage stage = new Stage();
            stage.setTitle("Neue Tätigkeit");
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleViewTask(ActionEvent event) {
        try {
            // FXML laden
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/noidontwantthat_java/view-task.fxml"));
            Parent root = fxmlLoader.load();

            // neue Szene
            Stage stage = new Stage();
            stage.setTitle("Tätigkeiten einsehen");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}