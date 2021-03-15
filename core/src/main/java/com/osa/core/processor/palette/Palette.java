package com.osa.core.processor.palette;

import java.awt.Color;

/**
 *
 * @author oleksii
 * @since Feb 13, 2021
 */
public abstract class Palette {
    
    protected double maxElement;
    
    public Palette(double maxElement) {
        this.maxElement = maxElement;
    }
    
    public abstract Color get(double value);
}
