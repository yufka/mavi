package com.osa.mavi.core.processor;

import com.osa.mavi.core.model.MatrixEntry;
import com.osa.mavi.core.model.MatrixFileMetadata;
import com.osa.mavi.core.io.MatrixFileReader;
import com.osa.mavi.core.model.MatrixFileStats;
import com.osa.mavi.core.processor.strategy.Strategy;
import com.osa.mavi.core.processor.strategy.StrategyFactory;
import com.osa.mavi.core.processor.strategy.StrategyName;
import com.osa.mavi.core.protrait.Portrait;

/**
 * Builder to create a Matrix Portrait.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class PortraitBuilder {
    
    private MatrixFileStats stats;
    
    private final Strategy[][] strategyMatrix;
    
    /**
     * Horizontal size of Portrait.
     */
    private final int width;
    
    /**
     * Vertical size of Portrait.
     */
    private final int height;
    
    /**
     * Boolean flag, if result values are all non-negative.
     * This might happen in case if we use {@link StrategyName#MAX_ABS_VAL} or {@link StrategyName#MID_ABS_VAL}
     */
    private final boolean absoluteVale;

    /**
     * Choose what dimension does Matrix Portrait have.
     * 
     * @param height vertical size of the Portrait
     * @param width horizontal size of the Portrait
     * @param strategyName name of strategy that should be used
     */
    public PortraitBuilder(final int height, final int width, final StrategyName strategyName) {
        this.height = height;
        this.width = width;
        strategyMatrix = new Strategy[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                strategyMatrix[i][j] = StrategyFactory.get(strategyName);
            }
        }
        this.absoluteVale = strategyMatrix[0][0].isAbsoluteValueStrategy();
    }
    
    public Portrait build(final MatrixFileReader reader) {
        stats = new MatrixFileStats(absoluteVale);
        MatrixFileMetadata meta = reader.getMetadata();
        MatrixEntry entry;
        while((entry = reader.getEntry()) != null) {
            int rowProjection = project(entry.getRow(), meta.getNumberOfRows(), height);
            int colProjection = project(entry.getColumn(), meta.getNumberOfColumns(), width);
            strategyMatrix[rowProjection][colProjection].process(entry.getValue());
            stats.processElement(entry.getValue());
        }
        
        Portrait portrait = new Portrait(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                portrait.set(i, j, strategyMatrix[i][j].getResult());
            }
        }
        return portrait;
    }
    
    /**
     * Project the index from matrix dimension to portrait dimensions
     * @param index row or column number of the matrix
     * @param matrixDim matrix size (in case if i -> width, in case of j -> height)
     * @param portraitDim portrait scale
     * @return 
     */
    private int project(int index, int matrixDim, int portraitDim) {
        float scale = (float) portraitDim / (float) matrixDim;
        return (int) (index * scale);
    }

    public MatrixFileStats getStats() {
        return stats;
    }
}
