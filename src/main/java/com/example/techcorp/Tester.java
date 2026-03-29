package com.example.techcorp;
public class Tester extends Employee {
    public Tester(String name, int skill, double salary) {
        super(name, skill, salary);
    }
    @Overridepublic int work() {
        return getSkill() / 2;
    }
}
 