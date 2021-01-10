package com.osa.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MaxAbsValueStrategy implements Strategy {
    
    public double maxCurrent = .0;

    @Override
    public void process(final double value) {
        if (Math.abs(value) > maxCurrent) {
            maxCurrent = Math.abs(value);
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
