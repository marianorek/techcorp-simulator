package com.example.techcorp.engine;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Employee;
import com.example.techcorp.domain.Project;
import com.example.techcorp.events.BonusEvent;
import com.example.techcorp.events.BugInProductionEvent;
import com.example.techcorp.events.GameEvent;
import com.example.techcorp.events.MarketSlowdownEvent;
import com.example.techcorp.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameEngine {

    private static final int WIN_REPUTATION = 100;
    private static final int MAX_TURNS = 30;
    private static final double EVENT_CHANCE = 0.35;

    private Company company;
    private ConsoleUI ui;
    private List<GameEvent> possibleEvents;
    private Random random = new Random();
    private int turn = 1;
    private boolean running = true;

    public GameEngine(Company company, ConsoleUI ui) {
        this.company = company;
        this.ui = ui;
        this.possibleEvents = new ArrayList<>();
        possibleEvents.add(new MarketSlowdownEvent());
        possibleEvents.add(new BonusEvent());
        possibleEvents.add(new BugInProductionEvent());
    }

    public void run() {
        ui.showMessage("Welcome to TechCorp! Reach reputation " + WIN_REPUTATION + " to win.");
        ui.showMessage("Watch out for bankruptcy and failed projects.\n");

        while (running) {
            ui.showTurn(turn);
            ui.showCompanyStatus(company);

            if (checkEndConditions()) break;

            ui.showMenu();
            int choice = ui.readChoice();

            switch (choice) {
                case 1:
                    workOneTurn();
                    triggerRandomEvent();
                    paySalaries();
                    turn++;
                    break;
                case 2:
                    hireEmployee();
                    break;
                case 3:
                    fireEmployee();
                    break;
                case 4:
                    startNewProject();
                    break;
                case 0:
                    running = false;
                    ui.showMessage("Game ended by player.");
                    break;
                default:
                    ui.showMessage("Invalid choice.");
            }

            if (turn > MAX_TURNS) {
                ui.showMessage("\nMax turns reached.");
                checkEndConditions();
                running = false;
            }
        }
    }

    private void workOneTurn() {
        for (Project p : company.getProjects()) {
            if (p.isActive()) {
                p.workOneTurn();
                if (p.isFinished()) {
                    company.addCash(p.getReward());
                    company.addReputation(p.getReputationReward());
                    ui.showMessage("Project '" + p.getName() + "' FINISHED! +"
                        + p.getReward() + " cash, +" + p.getReputationReward() + " reputation.");
                }
            }
        }
    }

    private void triggerRandomEvent() {
        if (random.nextDouble() < EVENT_CHANCE) {
            GameEvent event = possibleEvents.get(random.nextInt(possibleEvents.size()));
            event.apply(company);
            ui.showMessage("EVENT: " + event.getDescription());
        }
    }

    private void paySalaries() {
        double total = company.paySalaries();
        ui.showMessage("Paid salaries: " + total);
    }

    private void hireEmployee() {
        Employee newHire = ui.promptForNewEmployee();
        if (newHire != null) {
            company.hire(newHire);
            ui.showMessage("Hired " + newHire.getRoleName() + " " + newHire.getName() + ".");
        }
    }

    private void fireEmployee() {
        String name = ui.promptForFireName();
        boolean fired = company.fire(name);
        ui.showMessage(fired ? "Fired " + name + "." : "No employee named '" + name + "' found.");
    }

    private void startNewProject() {
        Project p = ui.promptForNewProject();
        ui.showMessage("Assign team members. Pick employees to assign:");
        while (true) {
            Employee chosen = ui.chooseEmployeeForProject(company);
            if (chosen == null) break;
            p.addEmployee(chosen);
            ui.showMessage("Assigned " + chosen.getName() + ".");
        }
        company.startProject(p);
        ui.showMessage("Project '" + p.getName() + "' started.");
    }

    private boolean checkEndConditions() {
        if (company.isBankrupt()) {
            ui.showMessage("\n*** GAME OVER: Company is bankrupt! ***");
            running = false;
            return true;
        }
        if (company.getReputation() >= WIN_REPUTATION) {
            ui.showMessage("\n*** YOU WIN! Reputation reached " + WIN_REPUTATION + "! ***");
            running = false;
            return true;
        }
        if (company.allProjectsFinished() && !company.getProjects().isEmpty()) {
            ui.showMessage("\n*** All projects finished! Final reputation: "
                + company.getReputation() + ". You win! ***");
            running = false;
            return true;
        }
        if (company.allProjectsFailed()) {
            ui.showMessage("\n*** GAME OVER: All projects failed! ***");
            running = false;
            return true;
        }
        return false;
    }
}
