package com.example.techcorp.events;

import com.example.techcorp.domain.Company;

public class MarketSlowdownEvent implements GameEvent {

    private static final double LOSS = 5000;

    @Override
    public void apply(Company company) {
        company.reduceCash(LOSS);
        company.addReputation(-5);
    }

    @Override
    public String getDescription() {
        return "Market slowdown! Company lost " + LOSS + " cash and 5 reputation.";
    }
}
