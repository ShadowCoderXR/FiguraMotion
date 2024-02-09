package com.figuramotion.figuramotion.entities.figures3D;

import javafx.scene.paint.Color;
import javafx.scene.shape.Cylinder;

public class CylinderF {
    private Cylinder cylinder;

    public void Cylinder(double radius, double height) {
        cylinder = new Cylinder(radius, height);
        cylinder.setMaterial(new javafx.scene.paint.PhongMaterial(Color.GREEN));
    }

    public Cylinder getCylinder() {
        return cylinder;
    }
}
