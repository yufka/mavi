package com.osa.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public enum StrategyName {

    MAX_VAL, MAX_ABS_VAL, MID_VAL, MID_ABS_VAL;
    
    public static boolean isAbsoluteValueStrategy(final StrategyName name) {
        switch (name) {
            case MAX_ABS_VAL:
            case MID_ABS_VAL:
                return true;
            case MAX_VAL:
            case MID_VAL:
                return false;
            default:
                throw new IllegalArgumentException("Unknown strategy name");
        }
    }
}
