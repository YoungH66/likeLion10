package com.example.day17.exam;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
public class Exam4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

       /* Map<String, List<Employee>> depMap // Map으로 그룹화. 이 경우 그룹화 기준인 부서이름이 String이기 때문에 String으로 설정
                = employees.stream()    // employees로 stream 열고
                .collect(Collectors.groupingBy(Employee::getDepartment));   // getDepartment로 그룹화*/

        Map<String, Double> depMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        depMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
