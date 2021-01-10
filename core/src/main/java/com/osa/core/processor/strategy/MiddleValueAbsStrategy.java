package com.osa.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MiddleValueAbsStrategy implements Strategy {
    
    private double result = .0;
    
    private long count = 0;

    @Override
    public void process(double value) {
        result += Math.abs(value);
        count++;
    }

    @Override
    public double getResult() {
        return count > 0 ? result / count : .0;
    }

    @Override
    public StrategyName getName() {
        return StrategyName.MID_AVG_VAL;
    }

}
