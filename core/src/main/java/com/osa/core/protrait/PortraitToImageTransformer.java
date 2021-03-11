package com.osa.core.protrait;

import com.osa.core.processor.palette.Palette;
import java.awt.image.BufferedImage;

/**
 * This class transforms matrix Portrait into {@link BufferedImage} depending on palette.
 * 
 * @author oleksii
 * @since Mar 1, 2021
 */
public class PortraitToImageTransformer {

    private Palette palette;
    
    public PortraitToImageTransformer(Palette palette) {    
        this.palette = palette;
    }
    
    private PortraitToImageTransformer() {
    }
    
   
    public BufferedImage getImage(Portrait portrait) {
        if (portrait == null) {
            throw new IllegalArgumentException("Can not convert null object to image");
        }
       
        BufferedImage image = new BufferedImage(portrait.getHeight(), portrait.getWidth(), BufferedImage.TYPE_INT_ARGB);
        
        for (int i = 0; i < portrait.getHeight(); i++) {
            for (int j = 0; j < portrait.getWidth(); j++) {
                image.setRGB(i, j, (int) palette.get(portrait.getVal(i, j)).getRGB());
            }
        }
        return image;
    }
}
