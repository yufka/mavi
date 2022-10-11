package com.osa.mavi.core.protrait;

/**
 * This class represents a final stage of matrix transformation - a
 * Matrix Portrait.
 * 
 * Matrix portrait is a two-dim array, where each entry is a double that is
 * computed from the original matrix.
 * 
 * 
 * @author oleksii
 * @since Feb 13, 2021
 */
public class Portrait {

    private final int width;
    
    private final int height;
    
    private final double[][] values;
    
    public Portrait(final int height, final int width) {
        this.width = width;
        this.height = height;
        values = new double[height][width];
    }
    
    public void set(final int row, final int column, final double value) {
        this.values[row][column] = value;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public double getVal(final int i, final int j) {
        return values[i][j];
    }
}
