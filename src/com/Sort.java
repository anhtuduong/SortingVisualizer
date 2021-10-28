package com;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class Sort {

    public CNode[] array;
    public SequentialTransition swapList;
    public int countSwap = 0;
    public Button button;

    public Sort(CNode[] array) {
        this.array = array;
        swapList = new SequentialTransition();
        button = new Button("Sort");
    }

    public void swap(CNode a, CNode b) {
        int temp = a.value;
        a.setValue(b.value);
        b.setValue(temp);

        ParallelTransition parallelTransition = new ParallelTransition(a.change(Color.YELLOW, a.value),
                                                                        b.change(Color.YELLOW, b.value));
        swapList.getChildren().add(parallelTransition);
        countSwap++;
    }

    public Button getButton() {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                backgroundSortingAlgorithm();
                System.out.println("Total swap: " + countSwap);
                startSwapAnimation();
            }
        });
        return button;
    }

    public abstract void backgroundSortingAlgorithm();

    public void startSwapAnimation() {
        swapList.play();
    }
}
