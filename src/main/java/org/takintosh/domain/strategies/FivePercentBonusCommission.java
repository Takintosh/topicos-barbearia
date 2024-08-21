package org.takintosh.domain.strategies;

public class FivePercentBonusCommission implements CommissionStrategy {
    @Override
    public double calculateCommission(double baseCommission) {
        return baseCommission * 1.05;
    }
}