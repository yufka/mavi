package com.osa.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public enum StrategyName {

    MAX_VAL, // 1
    MAX_ABS_VAL, // 2
    MID_VAL, // 3
    MID_AVG_VAL, // 4
    CONST; // 5
    
    public static int get(StrategyName name) {
        switch (name) {
            case MAX_VAL:
                return 1;
            case MAX_ABS_VAL:
                return 2;
            case MID_VAL:
                return 3;
            case MID_AVG_VAL:
                return 4;
            case CONST:
                return 5;
            default:
                throw new IllegalArgumentException("Unknown strategy name");
        }
    }
    
    public static StrategyName get(final int id) {
        switch (id) {
            case 1:
                return MAX_VAL;
            case 2:
                return MAX_ABS_VAL;
            case 3:
                return MID_VAL;
            case 4:
                return MID_AVG_VAL;
            case 5:
                return CONST;
            default:
                throw new IllegalArgumentException("Unknown StrategyName ID : " + id);
        }
    }
}
