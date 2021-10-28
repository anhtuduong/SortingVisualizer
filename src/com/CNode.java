package com;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class CNode extends Rectangle{

    public int value;

    public CNode(int value){
        this.value = value;
        setHeight(value);
        setWidth(com.Main.COLUMN_WIDTH);
        setFill(Main.INITIAL_COLOR);
        setOpacity(80);
        setStroke(Color.BLACK);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public FillTransition change(Color toColor, double toValue) {
        FillTransition change = new FillTransition(Duration.millis(Main.DELAY), this);
        change.setToValue(toColor);
        change.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setHeight(toValue);
                //setFill(Main.INITIAL_COLOR);
            }
        });
        return change;
    }

    public FillTransition change(Color toColor) {
        FillTransition change = new FillTransition(Duration.millis(Main.DELAY), this);
        change.setToValue(toColor);
        return change;
    }
}
