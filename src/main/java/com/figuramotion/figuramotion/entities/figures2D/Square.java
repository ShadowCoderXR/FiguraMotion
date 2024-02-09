package com.figuramotion.figuramotion.entities.figures2D;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
    private Rectangle square;

    public void SquareFigure(double x, double y, double sideLength) {
        square = new Rectangle(x, y, sideLength, sideLength);
        square.setFill(Color.ORANGE);
    }

    public Rectangle getSquare() {
        return square;
    }
}
