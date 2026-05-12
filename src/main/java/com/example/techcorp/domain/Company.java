package com.example.techcorp.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private double cash;
    private int reputation;
    private List<Employee> employees;
    private List<Project> projects;

    public Company(String name, double cash) {
        validateName(name);
        validateCash(cash);
        this.name = name;
        this.cash = cash;
        this.reputation = 50;
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void hire(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        employees.add(employee);
    }

    public boolean fire(String employeeName) {
        if (employeeName == null || employeeName.isBlank()) {
            return false;
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equalsIgnoreCase(employeeName)) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public void startProject(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project cannot be null.");
        }
        projects.add(project);
    }

    public double paySalaries() {
        double total = 0;
        for (Employee e : employees) {
            total += e.getSalary();
        }
        cash -= total;
        return total;
    }

    public void addCash(double amount) {
        cash += amount;
    }

    public void reduceCash(double amount) {
        cash -= amount;
    }

    public void addReputation(int amount) {
        reputation += amount;
        if (reputation > 100) reputation = 100;
        if (reputation < 0) reputation = 0;
    }

    public boolean isBankrupt() {
        return cash < 0;
    }

    public boolean allProjectsFailed() {
        if (projects.isEmpty()) return false;
        for (Project p : projects) {
            if (!p.isFailed()) return false;
        }
        return true;
    }

    public boolean allProjectsFinished() {
        if (projects.isEmpty()) return false;
        for (Project p : projects) {
            if (!p.isFinished()) return false;
        }
        return true;
    }

    public String getName() { return name; }
    public double getCash() { return cash; }
    public int getReputation() { return reputation; }
    public List<Employee> getEmployees() { return employees; }
    public List<Project> getProjects() { return projects; }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be null or blank.");
        }
    }

    private void validateCash(double cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("Company cash cannot be negative.");
        }
    }
}
