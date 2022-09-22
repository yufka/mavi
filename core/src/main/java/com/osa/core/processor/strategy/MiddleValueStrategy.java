package com.osa.core.processor.strategy;

/**
 * Strategy that computes average value of numbers that
 * are processed.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MiddleValueStrategy implements Strategy {
    
    private long count = 0;

    private double result = .0;
    
    @Override
    public void process(double value) {
        result += value;
        count++;
    }

    @Override
    public double getResult() {
        return count > 0 ? result / count : .0;
    }

    @Override
    public StrategyName getName() {
        return StrategyName.MID_VAL;
    }    
}
