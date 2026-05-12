package com.example.techcorp;

public class Intern extends Employee {

    public Intern(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    @Override
    public int work() {
        return getSkill() / 4;
    }
    @Override
    public String getRoleName() {
        return "Intern";
    } // cwiczenie2

    @Override
    public String introduceYourself() {
        return "Hi, I'm " + getName() + ", an Intern. Still learning!";
    } //zadanie 3 dla ambitnych
}