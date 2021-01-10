package com.osa.core.image;

import com.osa.core.matrix.Matrix;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author oleksii
 * @since Dec 25, 2020
 */
public class MatrixPortrait {
    
    private BufferedImage bufferedImage;
    
    public void saveTo(final String fileName) throws IOException {
        File outputfile = new File(fileName + ".png");
        ImageIO.write(bufferedImage, "png", outputfile);
    }
}
    