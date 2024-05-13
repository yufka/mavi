package com.osa.mavi.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public class StrategyFactory {
    
    public static Strategy get(final StrategyName strategyName) {
        switch (strategyName) {
            case MAX_VAL:
                return new MaxValueStrategy();
            case MAX_ABS_VAL:
                return new MaxAbsValueStrategy();
            case MID_VAL:
                return new MiddleValueStrategy();
            case MID_ABS_VAL:
                return new MiddleAbsValueStrategy();
            default:
                throw new IllegalArgumentException("Can not find strategy with name");
        }
    }
}
