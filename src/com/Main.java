package com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {

    public static int NUM_COLUMN = 20;
    public static int WINDOW_WIDTH = 600;
    public static int WINDOW_HEIGHT = 500;
    public static double COLUMN_WIDTH = WINDOW_WIDTH / NUM_COLUMN;
    public static int DELAY = 10;
    public static Color INITIAL_COLOR = Color.GREEN;

    public CNode[] array;
    public Pane arrayField;
    public SettingField settingField;
    public VBox root;


    public Main() {
        arrayField = new Pane();
        arrayField.setMinHeight(WINDOW_HEIGHT - 100);
        array = new CNode[NUM_COLUMN];
        for(int i=0; i<NUM_COLUMN; i++){
            array[i] = new CNode(new Random().nextInt(WINDOW_HEIGHT - 100));
            array[i].setX(i * COLUMN_WIDTH);
            arrayField.getChildren().add(array[i]);
            System.out.println("column[" + i + "] = " + array[i].value + "\tX = " + array[i].getX());
        }

        settingField = new SettingField(array);
        root = new VBox(arrayField, settingField.getField());
        root.setSpacing(20);

    }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Sorting Visualizer");
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
