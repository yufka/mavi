package com.osa.core.palette;

import com.osa.core.io.MatrixFileStats;
import java.awt.Color;

/**
 * This palette represents a two Colored black-and-white Palette,
 * where returned color is only a gradation of gray color.
 * 
 * @author oleksii
 * @since Mar 14, 2021
 */
public class GreyscalePalette extends Palette {

    public GreyscalePalette(final MatrixFileStats stats) {
        super(stats);
    }

    @Override
    public Color get(double value) {
        if (maxElement == minElement) {
            return Color.WHITE;
        }
        double scaledValue = scale(value);
        int scaled = 255 - (int) (255.0 * scaledValue);
        return new Color(scaled, scaled, scaled);
    }
}
