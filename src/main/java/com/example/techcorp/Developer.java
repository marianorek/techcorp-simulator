package com.example.techcorp;

public class Developer extends Employee {

    private String mainLanguage;

    public Developer(String name, int skill, double salary, String mainLanguage) {
        super(name, skill, salary);
        this.mainLanguage = mainLanguage;
    }

    @Override
    public int work() {
        return getSkill();
    }

    @Override
    public String getRoleName() {
        return "Developer"; //cwiczenie2
    }

    public String getMainLanguage() {
        return mainLanguage;
    }// dodanie main language zadanie 1 dla ambitnych

    @Override
    public String introduceYourself() {
        return "Hi, I'm " + getName() + ", a Developer. My main language is " + mainLanguage + ".";
    }// zadanie 3 dla ambitnych
}