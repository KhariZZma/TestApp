package com.kopyshov.sample;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import com.kopyshov.sample.model.Employee;
import com.kopyshov.sample.model.MainModel;
import com.kopyshov.sample.months.JanuaryController;
import com.kopyshov.sample.months.JanuaryView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
    @FXML
    private GridPane monthGridPane;
    @FXML
    private VBox employeeList;
    public JanuaryController januaryController;
    public MainModel mainModel;
    public JanuaryView januaryView;
    int year;
    ToggleGroup employeeGroup = new ToggleGroup();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainModel = new MainModel();
        year = mainModel.getYear();
        januaryView = new JanuaryView(LocalDate.of(year, Month.JANUARY, 1));
        januaryController = new JanuaryController(monthGridPane, januaryView, mainModel);

        int numberOfRow = 0;
        monthGridPane.add(januaryView, 1, numberOfRow);
        //добавление списка сотрудников на RightSide
        //-------------------------------------------------------
        updateRightSide(mainModel);

    }

    private void updateRightSide(MainModel model) {
        for(Employee nextEmployee : model.getEmployeesList()) {
            ToggleButton tB = new ToggleButton();
            tB.setText(nextEmployee.getName());
            tB.setMinWidth(110);
            employeeList.getChildren().add(tB);
            tB.setToggleGroup(employeeGroup);
            tB.setOnAction((t) ->{
                if(tB.isSelected()) {
                    MainModel.setSelectedEmployee(nextEmployee);
                }
            });
        }
    }
        //-------------------------------------------------------
}
