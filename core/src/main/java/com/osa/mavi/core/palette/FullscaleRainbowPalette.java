package com.osa.mavi.core.palette;

import com.osa.mavi.core.io.MatrixFileStats;
import java.awt.Color;

/**
 * This palette maps negative numbers to blue colors
 * and positive numbers to red colors.
 * 
 * @author oleksii
 * @since Sep 21, 2022
 */
public class FullscaleRainbowPalette extends Palette {
    
    public FullscaleRainbowPalette(MatrixFileStats stats) {
        super(stats);
    }
    
    @Override
    public Color get(double value) {
        double scaledValue = scale(value);
        if (scaledValue == .0) {
            return Color.WHITE;
        } else if (scaledValue < .0) {
            int scaled = 255 + (int) (scaledValue * 255);
            return new Color(scaled, scaled, 255); // Blue colors scaled
        } else  {
            int scaled = 255 - (int) (scaledValue * 255);
            return new Color(255, scaled, scaled); // red colors scaled
        }
    }
}
