package com.figuramotion.figuramotion;

import com.figuramotion.figuramotion.entities.figures3D.Cube;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Figures3DController {
    @FXML
    private Pane figuresPane;

    @FXML
    private void onBackToHomeButtonClick() {
        Stage stage = (Stage) figuresPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        figuresPane.widthProperty().addListener((obs, oldVal, newVal) -> drawShapes());
        figuresPane.heightProperty().addListener((obs, oldVal, newVal) -> drawShapes());
    }

    private void drawShapes() {
        figuresPane.getChildren().clear();
        drawCube();
    }

    private void drawCube() {
        double cubeSize = 100.0;
        Cube cube = new Cube(cubeSize);
        cube.getCube().setTranslateX((figuresPane.getWidth() - cubeSize) / 2);
        cube.getCube().setTranslateY((figuresPane.getHeight() - cubeSize) / 2);

        figuresPane.getChildren().add(cube.getCube());

        RotateTransition cubeRotateTransition = new RotateTransition(Duration.seconds(3), cube.getCube());
        cubeRotateTransition.setAxis(Rotate.Y_AXIS);
        cubeRotateTransition.setByAngle(360);
        cubeRotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        cubeRotateTransition.play();
    }
}