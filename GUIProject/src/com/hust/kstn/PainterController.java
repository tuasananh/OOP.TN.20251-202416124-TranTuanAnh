package com.hust.kstn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private RadioButton penButton;

    @FXML
    private ToggleGroup tool;
    
    @FXML
    public void initialize() {
    	tool.selectToggle(penButton);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Paint color;
    	if (tool.getSelectedToggle().equals(penButton)) {
    		color = Color.BLACK;
    	} else {
    		color = Color.WHITE;
    	}
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void eraserButtonPressed(ActionEvent event) {

    }

    @FXML
    void penButtonPressed(ActionEvent event) {

    }

}

