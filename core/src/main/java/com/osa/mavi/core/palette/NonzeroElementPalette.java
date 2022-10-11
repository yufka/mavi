package com.osa.mavi.core.palette;

import com.osa.mavi.core.io.MatrixFileStats;
import java.awt.Color;

/**
 * Palette that maps nonzero elements in blocks (if present) to black color.
 * 
 * @author oleksii
 * @since Sep 22, 2022
 */
public class NonzeroElementPalette extends Palette {

    public NonzeroElementPalette(MatrixFileStats stats) {
        super(stats);
    }
    
    @Override
    public Color get(double value) {
        if (Math.abs(value) > .0) {
            return Color.BLACK;
        }
        return Color.WHITE;
    }

}
