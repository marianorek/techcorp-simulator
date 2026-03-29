package com.example.techcorp; // caly nowy kod - cwiczenie 4

public class Main {

    public static void main(String[] args) {
        Company company = new Company("TechCorp", 50_000);

        Employee anna = new Developer("Anna", 9, 8_000);
        Employee piotr = new Tester("Piotr", 6, 6_500);
        Employee ewa = new Manager("Ewa", 7, 9_000);
        Employee kacper = new Intern("Kacper", 8, 3_000);

        company.hire(anna);
        company.hire(piotr);
        company.hire(ewa);
        company.hire(kacper);

        // Projekt 1 - same osoby techniczne - skonczyla sie w turze 4 czyli lepiej niz website w turze 10
        Project mobileApp = new Project("Mobile App", 40);
        mobileApp.addEmployee(anna);
        mobileApp.addEmployee(piotr);

        // Projekt 2 - manager i stażysta
        Project website = new Project("Website", 40);
        website.addEmployee(ewa);
        website.addEmployee(kacper);

        company.startProject(mobileApp);
        company.startProject(website);

        int turn = 1;
        while (!mobileApp.isFinished() || !website.isFinished()) {
            System.out.println("\n--- TURN " + turn + " ---");
            if (!mobileApp.isFinished()) mobileApp.workOneTurn();
            if (!website.isFinished()) website.workOneTurn();

            System.out.println("Mobile App:  " + mobileApp.getProgress() + "/40 (" + mobileApp.getCompletionPercentage() + "%)");
            System.out.println("Website:     " + website.getProgress() + "/40 (" + website.getCompletionPercentage() + "%)");
            turn++;
        }

        System.out.println("\nMobile App finished after: " + (turn - 1) + " turns");
        System.out.println("Website finished after: " + (turn - 1) + " turns");
    }
}