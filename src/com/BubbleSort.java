package com;

import javafx.scene.paint.Color;

public class BubbleSort extends Sort{

    public BubbleSort(CNode[] array) {
        super(array);
        button.setText("Bubble Sort");
    }

    @Override
    public void backgroundSortingAlgorithm() {
        int i, j;
        boolean swapped;

        for(i=0; i<Main.NUM_COLUMN-1; i++) {
            swapped = false;
            swapList.getChildren().add(array[i].change(Color.YELLOW));
            for(j=0; j<Main.NUM_COLUMN-i-1; j++) {
                swapList.getChildren().add(array[j].change(Color.YELLOW));
                if(array[j].value > array[j+1].value) {
//                    System.out.println("Swap column[" + j + "] with column [" + j+1 + "]");
                    swap(array[j], array[j+1]);
                    swapped = true;
                }
                swapList.getChildren().add(array[j].change(Main.INITIAL_COLOR));
                swapList.getChildren().add(array[j+1].change(Main.INITIAL_COLOR));
            }
            swapList.getChildren().add(array[i].change(Main.INITIAL_COLOR));
            if(swapped == false) {
                break;
            }
        }
    }

}
