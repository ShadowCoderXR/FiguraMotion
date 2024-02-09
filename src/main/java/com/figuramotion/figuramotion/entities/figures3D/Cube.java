package com.figuramotion.figuramotion.entities.figures3D;

import javafx.scene.paint.Color;
import javafx.scene.shape.Box;

public class Cube {
    private Box cube;

    public Cube(double size) {
        cube = new Box(size, size, size);
        cube.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLUE));
    }

    public Box getCube() {
        return cube;
    }
}
