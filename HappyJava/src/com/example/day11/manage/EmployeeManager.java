package com.example.day11.manage;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    Set<Employee> employeeManager = new HashSet<>();

    void addEmployee(Employee employee) {
        if(employeeManager.contains(employee)) {
            System.out.println("이미 존재하는 사원입니다.");
        }else {
            System.out.println("사원 추가 성공: " + employee.toString());
            this.employeeManager.add(employee);
        }
    }

    void findEmployee(String id) {
        for (Employee employee : employeeManager) {
            if (employee.getId().equals(id)) {
                System.out.println("사원 검색 성공 : " + employee.toString());
                return;
            }
        }
        System.out.println("해당 사원을 찾을 수 없습니다.");
    }

    void removeEmployee(Employee employee) {
        System.out.println("사원 삭제 성공 : " + employee.toString());
        this.employeeManager.remove(employee);
    }
}
