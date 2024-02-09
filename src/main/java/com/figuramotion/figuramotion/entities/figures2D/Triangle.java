package com.figuramotion.figuramotion.entities.figures2D;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Triangle {
    private Polygon triangle;

    public void TriangleFigure(double x1, double y1, double x2, double y2, double x3, double y3) {
        triangle = new Polygon();
        triangle.getPoints().addAll(x1, y1, x2, y2, x3, y3);
        triangle.setFill(Color.RED);
    }

    public Polygon getTriangle() {
        return triangle;
    }
}
