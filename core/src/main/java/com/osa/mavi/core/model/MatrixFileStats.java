package com.osa.mavi.core.model;

import lombok.Data;

/**
 *
 * @author oleksii
 * @since Mar 15, 2021
 */
@Data
public class MatrixFileStats {
    private double maxElement;
    private double minElement;
    private final boolean absolute;

    public MatrixFileStats(final boolean absolute) {
        this.absolute = absolute;
        this.minElement = Double.MAX_VALUE;
        this.maxElement = Double.MIN_VALUE;
    }

    public void processElement(double element) {
        double normalizedValue = absolute ? Math.abs(element) : element;
        if (this.minElement > normalizedValue) {
            this.minElement = normalizedValue;
        }
        if (this.maxElement < normalizedValue) {
            this.maxElement = normalizedValue;
        }
    }
}
