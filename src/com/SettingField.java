package com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Random;

public class SettingField extends VBox {

    public CNode[] array;

    public SettingField(CNode[] array) {
        this.array = array;
        setSpacing(10);

        BubbleSort bubbleSort = new BubbleSort(array);

        HBox sortField = new HBox();
        sortField.setAlignment(Pos.CENTER);
        sortField.getChildren().add(bubbleSort.getButton());

        Button reset = new Button("Reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for(int i=0; i<Main.NUM_COLUMN; i++){
                    array[i].setValue(new Random().nextInt(Main.WINDOW_HEIGHT - 100));
                    array[i].setHeight(array[i].value);
                    System.out.println("column[" + i + "] = " + array[i].value + "\tX = " + array[i].getX());
                }
            }
        });

        getChildren().add(sortField);
        getChildren().add(new StackPane(reset));
    }

    public VBox getField() {
        return this;
    }

}
