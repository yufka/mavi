package com.osa.mavi.core.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author oleksii
 * @since Dec 25, 2020
 */
public class BufferedImageWriter {
    
    private final BufferedImage bufferedImage;
    
    public BufferedImageWriter(BufferedImage image) {
        if (image == null) {
            throw new IllegalArgumentException("Can not create writer for null object");
        }
        this.bufferedImage = image;
    }
    
    public void saveTo(final String fileName) throws IOException {
        File outputfile = new File(fileName + ".png");
        ImageIO.write(bufferedImage, "png", outputfile);
    }
}
    