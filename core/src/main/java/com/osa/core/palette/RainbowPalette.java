package com.osa.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * A Palette to generate rainbow colors.
 * 
 * @author oleksii
 * @since Jul 5, 2021
 */
public class RainbowPalette extends Palette {
    
    private static final List<Color> RAINBOW_POINTS = Arrays.asList(Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.BLUE, Color.MAGENTA);
    
    public RainbowPalette(final double maxElement) {
        super(maxElement);
    }

    @Override
    public Color get(double value) {
        int length = RAINBOW_POINTS.size() - 1;
        double ratio = value / this.maxElement;
        int minElementIndex = (int) (ratio * length);
        if (minElementIndex == 0) {
            return RAINBOW_POINTS.get(0);
        } else {
            try {
            return getColorInTheMiddle(RAINBOW_POINTS.get(minElementIndex), RAINBOW_POINTS.get(minElementIndex + 1), 
                    ratio);
            } catch (Exception e) {
                System.out.println(ratio + ", " + minElementIndex);
                return Color.WHITE;
            }
        }
    }
    
    private Color getColorInTheMiddle(final Color left, final Color right, final double ratio) {
        return new Color(
                getMiddle(left.getRed(), right.getRed(), ratio),
                getMiddle(left.getGreen(), right.getGreen(), ratio),
                getMiddle(left.getBlue(), right.getBlue(), ratio)
        );
    }

    private int getMiddle(final int left, final int red, final double ratio) {
        return left + (int)((red - left) / ratio)-1;
    }
}
