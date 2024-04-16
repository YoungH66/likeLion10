package com.example.day11.manage;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    Set<Employee> employeeManager = new HashSet<>();

    void addEmployee(Employee employee) {
        this.employeeManager.add(employee);
    }

    void findEmployee(String id) {
        for (Employee employee : employeeManager) {
            if (employee.getId().equals(id)) {
                System.out.println(employee.getName() + " " + employee.getId() + " " +employee.getDepartment());
            }
        }
    }

    void removeEmployee(Employee employee) {
        this.employeeManager.remove(employee);
    }
}
