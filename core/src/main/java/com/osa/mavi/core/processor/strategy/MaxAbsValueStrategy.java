package com.osa.mavi.core.processor.strategy;

/**
 * This strategy computes the maximum absolute value
 * over all numbers that are processed.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MaxAbsValueStrategy implements Strategy {
    
    public double maxCurrent = .0;

    @Override
    public void process(final double value) {
        double absoluteValue = Math.abs(value);
        if (absoluteValue > maxCurrent) {
            maxCurrent = absoluteValue;
        }
    }

    @Override
    public double getResult() {
        return maxCurrent;
    }
    
    @Override
    public StrategyName getName() {
        return StrategyName.MAX_ABS_VAL;
    }
}
