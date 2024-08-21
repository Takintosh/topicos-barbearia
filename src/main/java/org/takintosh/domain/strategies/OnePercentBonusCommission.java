package org.takintosh.domain.strategies;

public class OnePercentBonusCommission implements CommissionStrategy {
    @Override
    public double calculateCommission(double baseCommission) {
        return baseCommission * 1.01;
    }
}