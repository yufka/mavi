package com.osa.core.io.reader;

/**
 *
 * @author oleksii
 * @since Mar 15, 2021
 */
public class MatrixFileStats {

    private double maxElement = Double.MIN_VALUE;
    
    private double minElement = Double.MAX_VALUE;

    public double getMaxElement() {
        return maxElement;
    }


    public double getMinElement() {
        return minElement;
    }

    public void processElement(double element) {
        if (this.minElement > element) {
            this.minElement = element;
        }
        if (this.maxElement < element) {
            this.maxElement = element;
        }
    }
}
