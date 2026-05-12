package com.example.techcorp.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private int requiredWork;
    private int progress;
    private double reward;
    private int reputationReward;
    private List<Employee> team;
    private ProjectStatus status;

    public Project(String name, int requiredWork, double reward, int reputationReward) {
        validateName(name);
        validateRequiredWork(requiredWork);
        validateReward(reward);
        validateReputationReward(reputationReward);
        this.name = name;
        this.requiredWork = requiredWork;
        this.reward = reward;
        this.reputationReward = reputationReward;
        this.progress = 0;
        this.team = new ArrayList<>();
        this.status = ProjectStatus.IN_PROGRESS;
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }
        team.add(employee);
    }

    public void workOneTurn() {
        if (status != ProjectStatus.IN_PROGRESS) return;
        for (Employee employee : team) {
            progress += employee.work();
        }
        if (progress >= requiredWork) {
            progress = requiredWork;
            status = ProjectStatus.FINISHED;
        }
    }

    public void markFailed() {
        this.status = ProjectStatus.FAILED;
    }

    public boolean isFinished() {
        return status == ProjectStatus.FINISHED;
    }

    public boolean isFailed() {
        return status == ProjectStatus.FAILED;
    }

    public boolean isActive() {
        return status == ProjectStatus.IN_PROGRESS;
    }

    public int getCompletionPercentage() {
        return (progress * 100) / requiredWork;
    }

    public String getName() { return name; }
    public int getRequiredWork() { return requiredWork; }
    public int getProgress() { return progress; }
    public double getReward() { return reward; }
    public int getReputationReward() { return reputationReward; }
    public List<Employee> getTeam() { return team; }
    public ProjectStatus getStatus() { return status; }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be null or blank.");
        }
    }

    private void validateRequiredWork(int requiredWork) {
        if (requiredWork <= 0) {
            throw new IllegalArgumentException("Required work must be greater than 0.");
        }
    }

    private void validateReward(double reward) {
        if (reward < 0) {
            throw new IllegalArgumentException("Reward cannot be negative.");
        }
    }

    private void validateReputationReward(int reputationReward) {
        if (reputationReward < 0) {
            throw new IllegalArgumentException("Reputation reward cannot be negative.");
        }
    }
}
