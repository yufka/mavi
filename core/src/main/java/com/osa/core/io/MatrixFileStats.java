package com.osa.core.io;

/**
 *
 * @author oleksii
 * @since Mar 15, 2021
 */
public class MatrixFileStats {

    private double maxElement;
    
    private double minElement;
    
    private final boolean abolute;
    
    public MatrixFileStats(final boolean absolute) {
        this.abolute = absolute;
        this.minElement = Double.MAX_VALUE;
        this.maxElement = Double.MIN_VALUE;
    }

    public double getMaxElement() {
        return maxElement;
    }

    public double getMinElement() {
        return minElement;
    }

    public void processElement(double element) {
        double normalizedValue = abolute ? Math.abs(element) : element;
        if (this.minElement > normalizedValue) {
            this.minElement = normalizedValue;
        }
        if (this.maxElement < normalizedValue) {
            this.maxElement = normalizedValue;
        }
    }

    public boolean isAbolute() {
        return abolute;
    }
}
