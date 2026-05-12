package com.example.techcorp.domain;

public class Manager extends Employee {

    public Manager(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    @Override
    public int work() {
        return getSkill() / 3;
    }

    @Override
    public String getRoleName() {
        return "Manager";
    }

    @Override
    public String introduceYourself() {
        return "Hi, I'm " + getName() + ", a Manager. I keep the team organized.";
    }
}
