package com.example.techcorp.domain;

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
        return "Developer";
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    @Override
    public String introduceYourself() {
        return "Hi, I'm " + getName() + ", a Developer. My main language is " + mainLanguage + ".";
    }
}
