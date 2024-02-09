package com.figuramotion.figuramotion.entities.figures3D;

import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Pyramid {
    private MeshView pyramid;

    public Pyramid(double size) {
        float h = (float) size / 2; // Half size
        float[] points = {
                // Base
                -h, 0, -h,
                h, 0, -h,
                0, 0, h, // Top vertex
                // Triangular faces
                -h, 0, -h,
                h, 0, -h,
                0, 0, h,
                -h, 0, -h,
                0, 0, h,
                0, 0, -h,
                h, 0, -h,
                0, 0, h,
                0, 0, -h
        };
        int[] faces = {
                // Faces
                0, 0, 1, 0, 2, 0,
                3, 0, 4, 0, 5, 0,
                6, 0, 7, 0, 8, 0
        };

        TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().setAll(points);
        mesh.getFaces().setAll(faces);
        pyramid = new MeshView(mesh);
        pyramid.setDrawMode(javafx.scene.shape.DrawMode.FILL);
        pyramid.setMaterial(new javafx.scene.paint.PhongMaterial(Color.RED));
    }

    public MeshView getPyramid() {
        return pyramid;
    }
}