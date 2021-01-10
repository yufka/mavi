package com.osa.core.processor.strategy;

/**
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
        return maxCurrent;
    }
    
    @Override
    public StrategyName getName() {
        return StrategyName.MAX_VAL;
    }
}
