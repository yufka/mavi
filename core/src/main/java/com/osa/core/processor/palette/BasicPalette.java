package com.osa.core.processor.palette;

import java.awt.Color;

/**
 * A basic color mapping palette for image. Just something for testing.
 * 
 * @author oleksii
 * @since Feb 13, 2021
 */
public class BasicPalette implements Palette {

    @Override
    public Color get(double value) {
        if (value >= 0.0 && value < 20.0) {
            return Color.RED;
        } else if (value >= 20.0 && value < 40.0) {
            return Color.GREEN;
        } else if (value >= 40.0 && value < 60.0) {
            return Color.YELLOW;
        } else {
            return Color.BLUE;
        }
    }
}
