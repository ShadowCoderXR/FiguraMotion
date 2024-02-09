package com.figuramotion.figuramotion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    protected void onFigures2DButtonClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("figures2D-view.fxml"));
        VBox figures2DPane = fxmlLoader.load();
        Scene scene = new Scene(figures2DPane, 320, 240);
        stage.setTitle("2D Figures");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onFigures3DButtonClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("figures3D-view.fxml"));
        VBox figures3DPane = fxmlLoader.load();
        Scene scene = new Scene(figures3DPane, 320, 240);
        stage.setTitle("3D Figures");
        stage.setScene(scene);
        stage.show();
    }
}