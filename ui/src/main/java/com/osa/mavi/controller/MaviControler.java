package com.osa.mavi.controller;

import com.osa.mavi.core.processor.strategy.StrategyName;
import com.osa.mavi.ui.util.MaviCoreUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author oleksii
 * @since Sep 30, 2022
 */
public class MaviControler {
    
    private static final String SERVICE = MaviControler.class.getName();

    private static final Logger LOGGER = Logger.getLogger(SERVICE);
    
    private static final int DEFAULT_DIMENSION = 320;
    
    private MatrixStatsWithImage previewStats = null;
    
    private String matrixFilePath = null;
    
    public MaviControler() {
        clean();
    }
    
    public void setMatrixFilePath(final String matrixFilePath) {
        this.matrixFilePath = matrixFilePath == null || matrixFilePath.trim().isEmpty() ? null : matrixFilePath.trim();
    }
    
    public void reload(final int strategyIndex, final int paletteIndex) {
        StrategyName strategy = getStrategy(strategyIndex);
        // Extract matrix dimentions first to generate proportional preview
        MatrixStats stats = MaviCoreUtils.getMatrixStats(matrixFilePath);
        if (stats != null) {
            int defaultWidth = stats.getNumberOfColumns() == stats.getNumberOfColumns() ? DEFAULT_DIMENSION :
                    DEFAULT_DIMENSION * (stats.getNumberOfColumns() / stats.getNumberOfRows());
                previewStats = MaviCoreUtils.getMatrixImage(matrixFilePath,
                    DEFAULT_DIMENSION, defaultWidth, strategy, paletteIndex);
        }
    }

    private void clean() {
        matrixFilePath = null;
        previewStats = null;
    }

    public MatrixStatsWithImage getPreviewStats() {
        return previewStats;
    }

    public void saveMatrixPortraitFile(final String filePath, final int width, final int height,
            final int strategyIndex, final int paletteIndex) {
        try {
            MaviCoreUtils.saveMatrixFile(matrixFilePath, width, height,
                    getStrategy(strategyIndex), filePath, paletteIndex);
        } catch (Exception e) {
            LOGGER.error(SERVICE, e);
        }
    }
    
    private StrategyName getStrategy(int selectedItemIndex) {
        switch (selectedItemIndex) {
            case 0:
                return StrategyName.MAX_VAL;
            case 1:
                return StrategyName.MAX_ABS_VAL;
            case 2:
                return StrategyName.MID_VAL;
            case 3:
                return StrategyName.MID_ABS_VAL;
            default:
                throw new IllegalArgumentException("Invalid strategy index");
        }
    }
}
