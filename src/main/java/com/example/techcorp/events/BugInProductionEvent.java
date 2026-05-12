package com.example.techcorp.events;

import com.example.techcorp.domain.Company;

public class BugInProductionEvent implements GameEvent {

    private static final double LOSS = 2000;

    @Override
    public void apply(Company company) {
        company.reduceCash(LOSS);
        company.addReputation(-10);
    }

    @Override
    public String getDescription() {
        return "Bug in production! Company lost " + LOSS + " cash and 10 reputation.";
    }
}
