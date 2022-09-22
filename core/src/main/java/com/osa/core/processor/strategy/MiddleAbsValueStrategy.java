package com.osa.core.processor.strategy;

/**
 * This strategy computes the average of absolute values
 * of processed numbers.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MiddleAbsValueStrategy implements Strategy {
    
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
        return StrategyName.MID_ABS_VAL;
    }
}