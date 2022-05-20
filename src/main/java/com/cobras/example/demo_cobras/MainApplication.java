package com.cobras.example.demo_cobras;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("cobra.fxml"));
        Scene scene= new Scene(fxmlLoader.load(), 400, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch(); }
}

