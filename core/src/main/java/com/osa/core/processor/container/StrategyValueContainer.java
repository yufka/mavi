package com.osa.core.processor.container;

import com.osa.core.processor.strategy.Strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public class StrategyValueContainer {
    
    private final Strategy strategy;
    
    public StrategyValueContainer(final Strategy strategy) {
        this.strategy = strategy;
    }
    
    public double getResult() {
        return strategy.getResult();
    }
}
