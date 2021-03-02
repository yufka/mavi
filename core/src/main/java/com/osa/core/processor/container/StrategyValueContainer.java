package com.osa.core.processor.container;

import com.osa.core.processor.strategy.Strategy;

/**
 * Container that represents a some part of matrix. This container is used to
 * accumulate values of matrix elements and finally represents a part of matrix
 * with one value that can be used to build matrix Portrait in the future steps.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class StrategyValueContainer implements Container {
    
    private final Strategy strategy;
    
    public StrategyValueContainer(final Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public double getValue() {
        return strategy.getResult();
    }
}
