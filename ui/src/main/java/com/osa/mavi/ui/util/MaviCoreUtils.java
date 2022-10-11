package com.osa.mavi.ui.util;

import com.osa.mavi.controller.ImageWithStats;
import com.osa.mavi.core.io.BufferedImageWriter;
import com.osa.mavi.core.io.MatrixFileReader;
import com.osa.mavi.core.io.MatrixMarketReader;
import com.osa.mavi.core.palette.GreyscalePalette;
import com.osa.mavi.core.palette.NonzeroElementPalette;
import com.osa.mavi.core.processor.PortraitBuilder;
import com.osa.mavi.core.processor.strategy.StrategyName;
import com.osa.mavi.core.protrait.Portrait;
import com.osa.mavi.core.protrait.PortraitToImageTransformer;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Utility class that provides functions of MaVi core module for image generation
 *
 * @author oleksii
 * @since Oct 11, 2022
 */
public class MaviCoreUtils {
    
    final static int PREVIEW_WIDTH = 320;
    
    final static int PREVIEW_HIGHT = 320;

    private static final String SERVICE = MaviCoreUtils.class.getName();

    private static final Logger LOGGER = Logger.getLogger(SERVICE);

    public static ImageWithStats getMatrixImage(final String matrixFilePath, final int height, final int width,
            final StrategyName strategy) {
        try {
            MatrixFileReader reader = new MatrixMarketReader(matrixFilePath);
            PortraitBuilder builder = new PortraitBuilder(height, width, strategy);
            Portrait portrait = builder.build(reader);
            ImageWithStats imageStats = new ImageWithStats();
            imageStats.setImage(new PortraitToImageTransformer(new NonzeroElementPalette(builder.getStats()))
                    .getImage(portrait));
            imageStats.setNumberOfRows(reader.getNumberOfRows());
            imageStats.setNumberOfColumns(reader.getNumberOfColumns());
            imageStats.setNumberOfNonzeroes(reader.getNumberOfElements());
            return imageStats;
        } catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found : " + matrixFilePath, fnfe);
        } catch (IOException ioe) {
            LOGGER.error("Could not read file : " + matrixFilePath, ioe);
        }
        return null;
    }

    public static void saveMatrixFile(final String matrixFilePath, final int height, final int width,
            final StrategyName strategy, final String matrixPortraitFilePath) throws IOException {
        try {
            MatrixFileReader reader = new MatrixMarketReader(matrixFilePath);
            PortraitBuilder builder = new PortraitBuilder(height, width, strategy);
            Portrait portrait = builder.build(reader);            
            new BufferedImageWriter(new PortraitToImageTransformer(
                    new GreyscalePalette(builder.getStats())).getImage(portrait)).saveTo(matrixPortraitFilePath);
        } catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found : " + matrixFilePath, fnfe);
        } catch (IOException ioe) {
            LOGGER.error("Could not read file : " + matrixFilePath, ioe);
        }
    }
    
    public static ImageWithStats getMatrixPreview(final String matrixFilePath) {
        return getMatrixImage(matrixFilePath, PREVIEW_HIGHT, PREVIEW_WIDTH, StrategyName.MAX_VAL);
    }
}
