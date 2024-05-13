package com.osa.mavi.core.palette;

import com.osa.mavi.core.model.MatrixFileStats;
import java.awt.Color;

/**
 *
 * @author oleksii
 * @since Feb 13, 2021
 */
public abstract class Palette {
    
    protected boolean absoluteValues;
    
    protected final double minElement;
    
    protected final double maxElement;
    
    protected double minMaxRange;
     
    public Palette(MatrixFileStats stats) {
        this.absoluteValues = stats.isAbsolute();
        this.minElement = stats.getMinElement();
        this.maxElement = stats.getMaxElement();
        this.minMaxRange = maxElement - minElement;
    }
    
    public abstract Color get(double value);
    
    /**
     * scale value to [0;1] or [-1; 1] range for further projection of color range.
     * The range depends on {@link #absoluteValues} parameter.
     * 
     * @param value
     * @return [0;1] or [-1; 1] scaled value.
     */
    protected double scale(double value) {
        if (absoluteValues) { // scale all to [0; 1]
            if (minMaxRange == .0) {
                return .0;
            }
            return (value - minElement) / minMaxRange;
        }
        if (value < .0) {
            return Math.abs(value) / minElement;
        } else if (value == .0) {
            return .0;
        } else {
            if (maxElement == .0) {
                return .0;
            }
            return value / maxElement;
        }
    }

}
