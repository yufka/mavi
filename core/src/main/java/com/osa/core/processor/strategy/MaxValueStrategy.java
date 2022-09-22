package com.osa.core.processor.strategy;

/**
 * This strategy computes the maximum value over all
 * numbers that are processed.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MaxValueStrategy implements Strategy {
    
    public double maxCurrent = Double.MIN_VALUE;

    @Override
    public void process(double value) {
        if (value > maxCurrent) {
            maxCurrent = value;
        }
    }

    @Override
    public double getResult() {
        // the check below basically means, that nothing was found
        return maxCurrent == Double.MIN_VALUE ? 0 : maxCurrent;
    }
    
    @Override
    public StrategyName getName() {
        return StrategyName.MAX_VAL;
    }
}