package com.kopyshov.sample.months;

import com.kopyshov.sample.model.Employee;
import com.kopyshov.sample.model.MainModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.time.LocalDate;
import java.time.Month;

public class JanuaryController {
    public MainModel mainModel;
    public GridPane monthGridPane;
    public JanuaryView januaryView;
    public int LIMIT_OF_EMPLOYEES;
    public int year;
    LocalDate localDate;

    public JanuaryController(GridPane monthGridPane, JanuaryView januaryView, MainModel mainModel) {
        this.mainModel = mainModel;
        this.monthGridPane = monthGridPane;
        this.januaryView = januaryView;
        this.year = mainModel.getYear();
        this.LIMIT_OF_EMPLOYEES = mainModel.getLIMIT_OF_EMPLOYEES();
        localDate = LocalDate.of(year, Month.JANUARY, 1);

        for (int y = 2; y < (LIMIT_OF_EMPLOYEES + 2); y++) {
            for (int i = 2; i < (LIMIT_OF_EMPLOYEES + 2); i++) {
                Label nameEmployee = new Label("Name_" + (i - 1));
                nameEmployee.setDisable(false);
                nameEmployee.setStyle("-fx-background-color: gray;");
                nameEmployee.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                nameEmployee.setMinHeight(30);
                januaryView.add(nameEmployee, 0, i);
            }
            HBox hBoxSelectDates = new HBox(2);
            hBoxSelectDates.setDisable(false);
            for (int i = 0; i < localDate.lengthOfMonth(); i++) {
                int day = i + 1;
                int str = y;
                Button dateButton = new Button();
                dateButton.setStyle("-fx-background-color: snow;");
                HBox.setHgrow(dateButton, Priority.ALWAYS);
                dateButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                dateButton.setMinSize(30, 30);
                dateButton.setOnMouseClicked((t) -> {
                    if (dateButton.getStyle().equals("-fx-background-color: snow;")) {
                        dateButton.setStyle("-fx-background-color: yellow;");
                        LocalDate selectedDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), day);
                        Employee selectedEmployee = MainModel.getSelectedEmployee();
                        System.out.println(selectedEmployee.getName() + " show");
                        Label strLabel = (Label) januaryView.getChildren().get(str + 1);
                        System.out.println(strLabel.getText());
                        strLabel.setText("");
                        System.out.println(strLabel.getText());
                        //user.getSelectedDates().add(selectedDate);

                        //System.out.print(user.getUserName() + ": \t");
                        //user.getSelectedDates().forEach(date -> System.out.print(date + "\t"));
                        System.out.println(selectedDate);
                    } else {
                        dateButton.setStyle("-fx-background-color: snow;");
                        LocalDate selectedDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), day);
                        //user.getSelectedDates().remove(selectedDate);

                        //System.out.print(user.getUserName() + ": \t");
                        //user.getSelectedDates().forEach(date -> System.out.print(date + "\t"));
                        System.out.println(selectedDate + " removed");
                    }
                });
                hBoxSelectDates.getChildren().add(dateButton);
            }

            januaryView.add(hBoxSelectDates, 1, y);
            januaryView.setMargin(hBoxSelectDates, new Insets(1, 5, 1, 1));

        }

    }
}
