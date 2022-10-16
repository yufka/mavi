package com.osa.mavi.controller;

import java.awt.image.BufferedImage;

/**
 * Class represents matrix image (for saving and/or preview) and stats of matrix
 * 
 * @author oleksii
 * @since Oct 11, 2022
 */
public class MatrixStatsWithImage extends MatrixStats {

    
    private BufferedImage image;   

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
