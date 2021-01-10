package com.osa.core.processor;

import com.osa.core.processor.strategy.Strategy;
import com.osa.core.processor.strategy.StrategyFactory;
import com.osa.core.processor.strategy.StrategyName;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author oleksii
 * @since Dec 26, 2020
 */
public class MatrixElementClassifier {
    
    private final int imageHeight;
    
    private final int imageWidth;
    
    private final int matrixHeight;
    
    private final int matrixWidth;
    
    private final int matrixCellHeight;
    
    private final int matrixCellWidth;
    
    Map<Integer, Map<Integer, Strategy>> strategyMap;

    public MatrixElementClassifier(final int imageHeight, final int imageWidth,
            final int matrixHeight, final int matrixWidth,
            final StrategyName name) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.matrixHeight = matrixHeight;
        this.matrixWidth = matrixWidth;
        
        strategyMap = new HashMap<>();
        for (int i = 0; i < imageHeight; i++) {
            Map<Integer, Strategy> iMap = new HashMap<>();
            for (int j = 0; j < imageWidth; j++) {
                iMap.put(j, StrategyFactory.get(name));
            }
            strategyMap.put(i, iMap);
        }
        
        // find size of cells
        matrixCellHeight = matrixHeight / imageHeight;
        matrixCellWidth = matrixWidth / imageWidth;
        
    }
    
    public void classify(final int matrixRowNumber, final int matrixColNumber, final double val) {
        int imageRowNumber = matrixRowNumber / matrixCellHeight;
        int imageColNumber = matrixColNumber / matrixCellWidth;
        strategyMap.get(imageRowNumber).get(imageColNumber).process(val);
    }
    
}
