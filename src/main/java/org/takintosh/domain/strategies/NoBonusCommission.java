package org.takintosh.domain.strategies;

public class NoBonusCommission implements CommissionStrategy {
    @Override
    public double calculateCommission(double baseCommission) {
        return baseCommission;
    }
}