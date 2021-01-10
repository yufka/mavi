package com.osa.core.processor;

import com.osa.core.matrix.Matrix;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Builder to create a Matrix Portrait.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class PortraitBuilder {

    private final BufferedImage bufferedImage;

    private final int width;

    private final int height;

    /**
     * Choose what dimension does Matrix Portrait have.
     * 
     * @param width
     * @param height 
     */
    public PortraitBuilder(final int width, final int height) {
        this.width = width;
        this.height = height;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void build(final Matrix matrix) {
        for (int rowNumber = 0; rowNumber < matrix.getNumberOfRows(); rowNumber++) { // iterate over matrix rows
            int colIndexStart = matrix.getRowIndexList().get(rowNumber);
            int colIndexFinish = matrix.getRowIndexList().get(rowNumber + 1);
            for (int colNumber = colIndexStart; colNumber < colIndexFinish; colNumber++) {
                try {
                    bufferedImage.setRGB(rowNumber, matrix.getColIndexList().get(colNumber),
                            getColor(matrix.getValueList().get(matrix.getColIndexList().get(colNumber))));

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Row number: " + rowNumber + " colNumber : " + colNumber);
                }
            }
        }
    }

    private int getColor(double val) {
        if (val >= 0.0 && val < 40.0) {
            return Color.RED.getRGB();
        } else if (val > 40.0) {
            return Color.GREEN.getRGB();
        } else if (val < 0.0 && val > -40.0) {
            return Color.YELLOW.getRGB();
        } else {
            return Color.BLUE.getRGB();
        }
    }
}
