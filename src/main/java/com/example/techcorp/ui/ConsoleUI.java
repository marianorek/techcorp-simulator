package com.example.techcorp.ui;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.Employee;
import com.example.techcorp.domain.Intern;
import com.example.techcorp.domain.Manager;
import com.example.techcorp.domain.Project;
import com.example.techcorp.domain.Tester;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void showTurn(int turn) {
        System.out.println("\n========== TURN " + turn + " ==========");
    }

    public void showCompanyStatus(Company company) {
        System.out.println("=== COMPANY STATUS ===");
        System.out.println("Name: " + company.getName());
        System.out.println("Cash: " + company.getCash());
        System.out.println("Reputation: " + company.getReputation() + "/100");
        System.out.println("Employees: " + company.getEmployees().size());
        System.out.println("Projects: " + company.getProjects().size());
        System.out.println();

        if (company.getEmployees().isEmpty()) {
            System.out.println("No employees hired yet.");
        } else {
            System.out.println("Employees:");
            for (Employee e : company.getEmployees()) {
                System.out.println("- " + e.getRoleName() + ": " + e.getName()
                    + " | skill: " + e.getSkill() + " | salary: " + e.getSalary());
            }
        }
        System.out.println();

        if (company.getProjects().isEmpty()) {
            System.out.println("No active projects.");
        } else {
            System.out.println("Projects:");
            for (Project p : company.getProjects()) {
                System.out.println("- " + p.getName() + " | progress: " + p.getProgress() + "/" + p.getRequiredWork()
                    + " | completion: " + p.getCompletionPercentage() + "%"
                    + " | status: " + p.getStatus());
            }
        }
        System.out.println("======================");
    }

    public void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Work one turn");
        System.out.println("2. Hire employee");
        System.out.println("3. Fire employee");
        System.out.println("4. Start new project");
        System.out.println("0. Quit game");
        System.out.print("Choose: ");
    }

    public int readChoice() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public Employee promptForNewEmployee() {
        System.out.println("\n-- HIRE EMPLOYEE --");
        System.out.println("1. Developer");
        System.out.println("2. Tester");
        System.out.println("3. Manager");
        System.out.println("4. Intern");
        System.out.print("Role: ");
        int role = readChoice();

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        int skill = readPositiveInt("Skill (1-10): ");
        double salary = readNonNegativeDouble("Salary: ");

        switch (role) {
            case 1:
                System.out.print("Main language: ");
                String lang = scanner.nextLine().trim();
                return new Developer(name, skill, salary, lang.isBlank() ? "Java" : lang);
            case 2:
                int auto = readPositiveInt("Automation level (1-10): ");
                return new Tester(name, skill, salary, auto);
            case 3:
                return new Manager(name, skill, salary);
            case 4:
                return new Intern(name, skill, salary);
            default:
                System.out.println("Unknown role, hiring cancelled.");
                return null;
        }
    }

    public String promptForFireName() {
        System.out.print("Name of employee to fire: ");
        return scanner.nextLine().trim();
    }

    public Project promptForNewProject() {
        System.out.println("\n-- NEW PROJECT --");
        System.out.print("Project name: ");
        String name = scanner.nextLine().trim();
        int work = readPositiveInt("Required work: ");
        double reward = readNonNegativeDouble("Cash reward on completion: ");
        int repReward = readPositiveInt("Reputation reward on completion: ");
        return new Project(name, work, reward, repReward);
    }

    public Employee chooseEmployeeForProject(Company company) {
        if (company.getEmployees().isEmpty()) {
            System.out.println("No employees available.");
            return null;
        }
        System.out.println("Available employees:");
        for (int i = 0; i < company.getEmployees().size(); i++) {
            Employee e = company.getEmployees().get(i);
            System.out.println((i + 1) + ". " + e.getRoleName() + " " + e.getName());
        }
        System.out.print("Pick number (0 to stop): ");
        int idx = readChoice();
        if (idx <= 0 || idx > company.getEmployees().size()) return null;
        return company.getEmployees().get(idx - 1);
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value > 0) return value;
                System.out.println("Must be greater than 0.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number.");
            }
        }
    }

    private double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value >= 0) return value;
                System.out.println("Cannot be negative.");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number.");
            }
        }
    }
}
