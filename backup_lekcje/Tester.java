package com.example.techcorp;

public class Tester extends Employee {

    private int automationLevel;

    public Tester(String name, int skill, double salary, int automationLevel) {
        super(name, skill, salary);
        this.automationLevel = automationLevel;
    }

    @Override
    public int work() {
        return getSkill() / 2;
    }

    @Override
    public String getRoleName() {
        return "Tester"; //cwiczenie2
    }

    public int getAutomationLevel() {
        return automationLevel;
    }// dodanie automationlevel zadanie 2 dla ambitnych

    @Override
    public String introduceYourself() {
        return "Hi, I'm " + getName() + ", a Tester. My automation level is " + automationLevel + "/10.";
    }//zadanie 3 dla ambitnych
} 