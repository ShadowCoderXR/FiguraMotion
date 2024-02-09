package com.figuramotion.figuramotion.entities.figures2D;

import javafx.scene.paint.Color;

public class Circle {
    private javafx.scene.shape.Circle circle;

    public void CircleFigure(double centerX, double centerY, double radius) {
        circle = new javafx.scene.shape.Circle(centerX, centerY, radius);
        circle.setFill(Color.BLUE);
    }

    public javafx.scene.shape.Circle getCircle() {
        return circle;
    }
}
