package com.kopyshov.sample.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<LocalDate> selectedDates = new ArrayList<>();
    public Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public List<LocalDate> getSelectedDates() {
        return selectedDates;
    }
}
