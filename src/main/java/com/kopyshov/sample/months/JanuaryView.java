package com.kopyshov.sample.months;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.time.LocalDate;

public class JanuaryView extends GridPane {

    public JanuaryView(LocalDate localDate){
        this.setHgap(3);
        this.setVgap(3);
        this.setStyle("-fx-background-color: gainsboro;");
        generateHeader(localDate);
    }
    private void generateHeader(LocalDate localDate) {
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().add(new ColumnConstraints(100));
        this.getColumnConstraints().add(column2);
        Label nameMonth = new Label(localDate.getMonth().name());
        nameMonth.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nameMonth.setAlignment(Pos.CENTER);
        Label nameEmployees = new Label("Name Employee");
        nameEmployees.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(nameMonth, 1, 0);
        this.add(nameEmployees, 0, 1);
        //добавление чисел к месяцу
        HBox hBoxNumberDates = new HBox(2);
        for (int i = 0; i < localDate.lengthOfMonth(); i++) {
            Label labelNumberDates = new Label(Integer.toString(i+1));
            labelNumberDates.setStyle("-fx-background-color: lightblue;");
            HBox.setHgrow(labelNumberDates, Priority.ALWAYS);
            labelNumberDates.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            labelNumberDates.setMinSize(30,30);
            labelNumberDates.setAlignment(Pos.CENTER);
            hBoxNumberDates.getChildren().add(labelNumberDates);
        }
        this.add(hBoxNumberDates, 1, 1);
        this.setMargin(hBoxNumberDates, new Insets(1,5,1,1));
    }
}
