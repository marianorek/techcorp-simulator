package com.example.techcorp;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("TechCorp", 50_000);

        Employee anna = new Developer("Anna", 9, 8_000);
        Employee piotr = new Tester("Piotr", 6, 6_500);
        Employee ewa = new Manager("Ewa", 7, 9_000);

        company.hire(anna);
        company.hire(piotr);
        company.hire(ewa);

        Project mobileApp = new Project("Mobile App", 40);
        mobileApp.addEmployee(anna);
        mobileApp.addEmployee(piotr);
        mobileApp.addEmployee(ewa);

        company.startProject(mobileApp);

        System.out.println("INITIAL STATE");
        company.showStatus();

        int turn = 1;
        while (!mobileApp.isFinished()) {
            System.out.println("\n--- TURN " + turn + " ---");
            mobileApp.workOneTurn();
            company.showStatus();
            turn++;
        }

        System.out.println("\nProject '" + mobileApp.getName() + "' finished.");
    }
}
 