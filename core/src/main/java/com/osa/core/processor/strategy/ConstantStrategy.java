package com.osa.core.processor.strategy;

/**
 *
 * @author oleksii
 * @since Dec 26, 2020
 */
public class ConstantStrategy implements Strategy {
    
    private double value = .0;

    @Override
    public void process(double value) {
        this.value = value;
    }

    @Override
    public double getResult() {
        return value;
    }

    @Override
    public StrategyName getName() {
        return StrategyName.CONST;
    }

}
