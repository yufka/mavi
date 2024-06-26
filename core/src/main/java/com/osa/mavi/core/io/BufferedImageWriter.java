package com.osa.mavi.core.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author oleksii
 * @since Dec 25, 2020
 */
@Slf4j
public class BufferedImageWriter {
    private static final String PNG_STRING = "png";
    private static final String PNG_ENDING = "." + PNG_STRING;
    private final BufferedImage bufferedImage;
    
    public BufferedImageWriter(BufferedImage image) {
        if (image == null) {
            log.error("Can not create writer for null object");
            throw new IllegalArgumentException("Can not create writer for null object");
        }
        this.bufferedImage = image;
    }
    
    public void saveTo(final String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            log.warn("File name is null or empty");
            return;
        }
        String fileNameTrimmed = fileName.trim();
        File outputfile = new File(fileNameTrimmed.endsWith(PNG_ENDING) ? fileNameTrimmed : fileNameTrimmed + PNG_ENDING);
        ImageIO.write(bufferedImage, PNG_STRING, outputfile);
    }
}
    