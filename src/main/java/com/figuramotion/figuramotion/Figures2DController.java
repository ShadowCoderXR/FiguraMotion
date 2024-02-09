package com.figuramotion.figuramotion;

import com.figuramotion.figuramotion.entities.figures2D.Circle;
import com.figuramotion.figuramotion.entities.figures2D.Square;
import com.figuramotion.figuramotion.entities.figures2D.Triangle;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Figures2DController {

    @FXML
    private Button backButton;
    @FXML
    private Pane figuresPane;

    @FXML
    protected void initialize() {
        figuresPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() != 0) {
                drawRandomFigures();
            }
        });

        figuresPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() != 0) {
                drawRandomFigures();
            }
        });
    }


    @FXML
    protected void onBackToHomeButtonClick() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    private void drawRandomFigures() {
        Random random = new Random();
        double width = figuresPane.getWidth();
        double height = figuresPane.getHeight();

        figuresPane.getChildren().clear();

        int maxAttempts = 50;

        for (int i = 0; i < maxAttempts; i++) {
            double circleCenterX = random.nextDouble() * (width - 100) + 50;
            double circleCenterY = random.nextDouble() * (height - 100) + 50;
            double circleRadius = random.nextDouble() * 50 + 20;

            Circle circle = new Circle();
            circle.CircleFigure(circleCenterX, circleCenterY, circleRadius);

            if (!isOverlapping(circle.getCircle(), figuresPane.getChildren())) {
                figuresPane.getChildren().add(circle.getCircle());
                animateAndMove(circle.getCircle());
                break;
            }
        }

        for (int i = 0; i < maxAttempts; i++) {
            double squareX = random.nextDouble() * (width - 100) + 50;
            double squareY = random.nextDouble() * (height - 100) + 50;
            double squareSideLength = random.nextDouble() * 80 + 20;

            Square square = new Square();
            square.SquareFigure(squareX, squareY, squareSideLength);

            if (!isOverlapping(square.getSquare(), figuresPane.getChildren())) {
                figuresPane.getChildren().add(square.getSquare());
                animateAndMove(square.getSquare());
                break;
            }
        }

        for (int i = 0; i < maxAttempts; i++) {
            double x1 = random.nextDouble() * (width - 100) + 50;
            double y1 = random.nextDouble() * (height - 100) + 50;
            double x2 = random.nextDouble() * (width - 100) + 50;
            double y2 = random.nextDouble() * (height - 100) + 50;
            double x3 = random.nextDouble() * (width - 100) + 50;
            double y3 = random.nextDouble() * (height - 100) + 50;

            Triangle triangle = new Triangle();
            triangle.TriangleFigure(x1, y1, x2, y2, x3, y3);

            if (!isOverlapping(triangle.getTriangle(), figuresPane.getChildren())) {
                figuresPane.getChildren().add(triangle.getTriangle());
                animateAndMove(triangle.getTriangle());
                break;
            }
        }
    }

    private boolean isOverlapping(Shape shape, ObservableList<Node> nodes) {
        for (Node node : nodes) {
            if (node instanceof Shape && shape != node) {
                Shape otherShape = (Shape) node;
                if (shape.getBoundsInParent().intersects(otherShape.getBoundsInParent())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void animateAndMove(Node node) {
        Random random = new Random();
        int randomDelay = random.nextInt(2000);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(randomDelay));
        pauseTransition.setOnFinished(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), node);

            double randomScale = random.nextDouble() * 2.0;


            scaleTransition.setFromX(randomScale);
            scaleTransition.setToX(randomScale * 0.5);
            scaleTransition.setFromY(randomScale);
            scaleTransition.setToY(randomScale * 0.5);
            scaleTransition.setAutoReverse(true);
            scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);

            scaleTransition.play();
        });

        pauseTransition.play();
    }

}
