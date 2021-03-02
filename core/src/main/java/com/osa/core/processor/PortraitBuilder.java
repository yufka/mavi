package com.osa.core.processor;

import com.osa.core.matrix.Matrix;
import com.osa.core.processor.palette.Palette;
import com.osa.core.processor.strategy.Strategy;
import com.osa.core.processor.strategy.StrategyFactory;
import com.osa.core.processor.strategy.StrategyName;
import com.osa.core.protrait.Portrait;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Builder to create a Matrix Portrait.
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class PortraitBuilder {
    
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
    }
    
    public Portrait build(final Matrix matrix) {
        for (int rowNumber = 0; rowNumber < matrix.getNumberOfRows(); rowNumber++) { // iterate over matrix rows
            int colIndexStart = matrix.getRowIndexList().get(rowNumber);
            int colIndexFinish = matrix.getRowIndexList().get(rowNumber + 1);
            for (int colNumberIndex = colIndexStart; colNumberIndex < colIndexFinish; colNumberIndex++) {
                int colNumber = matrix.getColIndexList().get(colNumberIndex);   
                double val = matrix.getValueList().get(colNumberIndex);
                int rowProjection = project(rowNumber, matrix.getNumberOfRows(), height);
                int colProjection = project(colNumber, matrix.getNumberOfColumns(), width);
                strategyMatrix[rowProjection][colProjection].process(val);
            }
        }
        Portrait portrait = new Portrait(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(i + " " + j + " " + strategyMatrix[i][j].getResult());
                portrait.set(i, j, strategyMatrix[i][j].getResult());
                
            }
        }
        return portrait;
    }
    
    /**
     * Project the index from matrix dimention to portrait dimentions
     * @param index row or column number of the matrix
     * @param matrixDim matrix size (in case if i -> width, in case of j -> height)
     * @param portraitDim portrait scale
     * @return 
     */
    private int project(int index, int matrixDim, int portraitDim) {
        return index * (portraitDim / matrixDim);
    }
}
