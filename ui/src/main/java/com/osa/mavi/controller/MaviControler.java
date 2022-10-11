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
    
    private ImageWithStats previewStats = null;
    
    private String matrixFilePath = null;
    
    public MaviControler() {
        clean();
    }
    
    public void setMatrixFilePath(final String matrixFilePath) {
        this.matrixFilePath = matrixFilePath == null || matrixFilePath.trim().isEmpty() ? null : matrixFilePath.trim();
        previewStats = MaviCoreUtils.getMatrixPreview(matrixFilePath);
    }

    private void clean() {
        matrixFilePath = null;
        previewStats = null;
    }

    public ImageWithStats getPreviewStats() {
        return previewStats;
    }

    public void saveMatrixPortraitFile(final String filePath, final int width, final int height,
            final StrategyName strategy) {
        try {
            MaviCoreUtils.saveMatrixFile(matrixFilePath, width, height, strategy, filePath);
        } catch (Exception e) {
            LOGGER.error(SERVICE, e);
        }
    }
    
}
