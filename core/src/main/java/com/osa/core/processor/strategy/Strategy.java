package com.osa.core.processor.strategy;

/**
 * Interface of computation strategy how the part of matrix is processed.
 * 
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public interface Strategy {
    
    /**
     * Process input value.
     * 
     * @param value matrix entry
     */
    void process(double value);
    
    /**
     * Result of strategy
     * @return values.
     */
    double getResult();
    
    /**
     * Get name of strategy
     * @return name of strategy
     */
    StrategyName getName();
    
}
