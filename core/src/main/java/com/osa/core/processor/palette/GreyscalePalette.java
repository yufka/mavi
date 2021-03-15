package com.osa.core.processor.palette;

import com.osa.core.io.reader.MatrixFileMetadata;
import java.awt.Color;

/**
 * This palette represents a two Colored black-and-white Palette,
 * where returned color is only a gradation of grey color.
 * 
 * @author oleksii
 * @since Mar 14, 2021
 */
public class GreyscalePalette extends Palette {

    public GreyscalePalette(double maxElement) {
        super(maxElement);
    }

    @Override
    public Color get(double value) {
        int scaled = 255 - (int) (255.0 * value / maxElement);
        return new Color(scaled, scaled, scaled);
    }

}
