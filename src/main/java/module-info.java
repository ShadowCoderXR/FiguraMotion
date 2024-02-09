module com.figuramotion.figuramotion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.figuramotion.figuramotion to javafx.fxml;
    exports com.figuramotion.figuramotion;
    exports com.figuramotion.figuramotion.entities.figures2D;
    opens com.figuramotion.figuramotion.entities.figures2D to javafx.fxml;
}