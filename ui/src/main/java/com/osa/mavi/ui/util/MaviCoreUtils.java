package com.osa.mavi.ui.util;

import com.osa.mavi.controller.MatrixStats;
import com.osa.mavi.controller.MatrixStatsWithImage;
import com.osa.mavi.core.io.BufferedImageWriter;
import com.osa.mavi.core.io.MatrixFileReader;
import com.osa.mavi.core.io.MatrixFileStats;
import com.osa.mavi.core.io.MatrixMarketReader;
import com.osa.mavi.core.palette.FullscaleRainbowPalette;
import com.osa.mavi.core.palette.GreyscalePalette;
import com.osa.mavi.core.palette.Palette;
import com.osa.mavi.core.processor.PortraitBuilder;
import com.osa.mavi.core.processor.strategy.StrategyName;
import com.osa.mavi.core.protrait.Portrait;
import com.osa.mavi.core.protrait.PortraitToImageTransformer;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class that provides functions of MaVi core module for image generation
 *
 * @author oleksii
 * @since Oct 11, 2022
 */
public class MaviCoreUtils {
    
    private static final String SERVICE = MaviCoreUtils.class.getName();

    private static final Logger LOGGER = LogManager.getLogger(SERVICE);

    public static MatrixStatsWithImage getMatrixImage(final String matrixFilePath, final int height, final int width,
            final StrategyName strategy, final int paletteIndex) {
        try {
            MatrixFileReader reader = new MatrixMarketReader(matrixFilePath);
            PortraitBuilder builder = new PortraitBuilder(height, width, strategy);
            Portrait portrait = builder.build(reader);
            MatrixStatsWithImage imageStats = new MatrixStatsWithImage();
            imageStats.setImage(new PortraitToImageTransformer(getPalette(paletteIndex, builder.getStats()))
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
    
    public static MatrixStats getMatrixStats(final String matrixFilePath) {
        try {
            MatrixFileReader reader = new MatrixMarketReader(matrixFilePath);
            MatrixStats stats = new MatrixStats();
            stats.setNumberOfColumns(reader.getNumberOfColumns());
            stats.setNumberOfRows(reader.getNumberOfRows());
            stats.setNumberOfNonzeroes(reader.getNumberOfElements());
            return stats;
        }
        catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found : " + matrixFilePath, fnfe);
        } catch (IOException ioe) {
            LOGGER.error("Could not read file : " + matrixFilePath, ioe);
        }
        return null;
    }
    
    private static Palette getPalette(final int paletteIndex, final MatrixFileStats stats) {
        switch (paletteIndex) {
            case 0:
                return new GreyscalePalette(stats);
            case 1:
                return new FullscaleRainbowPalette(stats);
            default:
                throw new IllegalArgumentException("Invalid paletteIndex : " + paletteIndex);
        }
    }

    public static void saveMatrixFile(final String matrixFilePath, final int height, final int width,
            final StrategyName strategy, final String matrixPortraitFilePath, final int paletteIndex)
            throws IOException {
        try {
            MatrixFileReader reader = new MatrixMarketReader(matrixFilePath);
            PortraitBuilder builder = new PortraitBuilder(height, width, strategy);
            Portrait portrait = builder.build(reader);            
            new BufferedImageWriter(new PortraitToImageTransformer(
                    getPalette(paletteIndex, builder.getStats())).getImage(portrait)).saveTo(matrixPortraitFilePath);
        } catch (FileNotFoundException fnfe) {
            LOGGER.error("File not found : " + matrixFilePath, fnfe);
        } catch (IOException ioe) {
            LOGGER.error("Could not read file : " + matrixFilePath, ioe);
        }
    }    

}
