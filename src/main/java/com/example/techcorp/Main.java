package com.example.techcorp;

import com.example.techcorp.domain.Company;
import com.example.techcorp.domain.Developer;
import com.example.techcorp.domain.Employee;
import com.example.techcorp.domain.Intern;
import com.example.techcorp.domain.Manager;
import com.example.techcorp.domain.Project;
import com.example.techcorp.domain.Tester;
import com.example.techcorp.engine.GameEngine;
import com.example.techcorp.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("TechCorp", 80_000);

        Employee anna = new Developer("Anna", 9, 8_000, "Java");
        Employee piotr = new Tester("Piotr", 6, 6_500, 3);
        Employee ewa = new Manager("Ewa", 7, 9_000);
        Employee kacper = new Intern("Kacper", 8, 3_000);

        company.hire(anna);
        company.hire(piotr);
        company.hire(ewa);
        company.hire(kacper);

        System.out.println(anna.introduceYourself());
        System.out.println(piotr.introduceYourself());
        System.out.println(ewa.introduceYourself());
        System.out.println(kacper.introduceYourself());

        Project mobileApp = new Project("Mobile App", 40, 60_000, 25);
        mobileApp.addEmployee(anna);
        mobileApp.addEmployee(piotr);
        mobileApp.addEmployee(ewa);

        Project website = new Project("Website", 40, 50_000, 20);
        website.addEmployee(anna);
        website.addEmployee(kacper);

        company.startProject(mobileApp);
        company.startProject(website);

        ConsoleUI ui = new ConsoleUI();
        GameEngine engine = new GameEngine(company, ui);
        engine.run();
    }
}
