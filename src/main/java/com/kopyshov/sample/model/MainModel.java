package com.kopyshov.sample.model;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    ArrayList<Employee> employeesList = new ArrayList<>();
    public static Employee selectedEmployee;

    //добавляем для тестирования
    //-----------------------------------------------
    Employee dmitry = new Employee("Dmitry");
    Employee paulina = new Employee("Paulina");
    Employee milana = new Employee("Milana");
    //-------------------------------------------------
    int year;
    final int LIMIT_OF_EMPLOYEES = 3;
    public MainModel() {
        year = 2023;

        //тестовый метод
        //---------------------------------------------
        testingEmployees();
    }
    private void testingEmployees() {
        employeesList.add(dmitry);
        employeesList.add(paulina);
        employeesList.add(milana);
    }
        //----------------------------------------------

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public int getYear() {
        return year;
    }

    public int getLIMIT_OF_EMPLOYEES() {
        return LIMIT_OF_EMPLOYEES;
    }

    public static Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public static void setSelectedEmployee(Employee selectedEmployee) {
        MainModel.selectedEmployee = selectedEmployee;
    }
}
