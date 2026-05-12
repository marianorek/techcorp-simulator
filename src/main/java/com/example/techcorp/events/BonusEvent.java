package com.example.techcorp.events;

import com.example.techcorp.domain.Company;

public class BonusEvent implements GameEvent {

    private static final double BONUS = 3000;

    @Override
    public void apply(Company company) {
        company.addCash(BONUS);
        company.addReputation(3);
    }

    @Override
    public String getDescription() {
        return "Unexpected client bonus! Company gained " + BONUS + " cash and 3 reputation.";
    }
}
