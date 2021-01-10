package com.osa.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public class StrategyFactory {
    
    public static Strategy get(final int strategyId) {
        return get(StrategyName.get(strategyId));
    }
    
    public static Strategy get(final StrategyName strategyName) {
        switch (strategyName) {
            case MAX_VAL:
                return new MaxValueStrategy();
            case MAX_ABS_VAL:
                return new MaxAbsValueStrategy();
            case MID_VAL:
                return new MiddleValueStrategy();
            case MID_AVG_VAL:
                return new MiddleValueAbsStrategy();
            default:
                throw new IllegalArgumentException("Can not find strategy with name");
        }
    }

}
