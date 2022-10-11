package com.osa.mavi.controller;

import java.awt.image.BufferedImage;

/**
 * Class represents matrix image (for saving and/or preview) and stats of matrix
 * 
 * @author oleksii
 * @since Oct 11, 2022
 */
public class ImageWithStats {

    private int numberOfRows;
    
    private int numberOfColumns;
    
    private int numberOfNonzeroes;
    
    private BufferedImage image;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfNonzeroes() {
        return numberOfNonzeroes;
    }

    public void setNumberOfNonzeroes(int numberOfNonzeroes) {
        this.numberOfNonzeroes = numberOfNonzeroes;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
