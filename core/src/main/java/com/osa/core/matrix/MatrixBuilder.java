package com.osa.core.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * This matrix builder incrementally constructs a matrix by inserting elements one by one.
 * In is important, that number size of the matrix and number of non-zero elements is know before construction.
 * 
 * @author oleksii
 * @since Mar 8, 2021
 */
public class MatrixBuilder {
    
    private final int numberOfElements;
    
    private final int numberOfRows;
    
    private final int numberOfColumns;
    
    private final List<Integer> rowIndexList;
    
    private final List<Integer> colIndexList;
    
    private final List<Double> valueList;
    
    public MatrixBuilder(int numberOfRows, int numberOfColumns, int numberOfElements) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.numberOfElements = numberOfElements;
        this.rowIndexList = new ArrayList<>(numberOfRows + 1);
        for (int i = 0; i < numberOfRows + 1; i++) {
            rowIndexList.add(i, 0);
        }
        this.colIndexList = new ArrayList<>(numberOfElements);
        this.valueList = new ArrayList<>(numberOfElements);
    }
    
    /**
     * This method inserts a new element into matrix. In case if element already exists, this element will be
     * replaced.
     * 
     * @param row row index (1 based)
     * @param column column index (1 based)
     * @param value value that should be inserted
     */
    public void insertElement(final int row, final int column, final double value) {
        if (row > numberOfRows) {
            throw new IllegalArgumentException("Rows index out of bounds: " + row + " >= " + numberOfRows);
        }
        if (column > numberOfColumns) {
            throw new IllegalArgumentException("Columns index out of bounds: " + column + " >= " + numberOfColumns);
        }
        
        for (int i = rowIndexList.get(row - 1); i < rowIndexList.get(row); i++) { // iterate over columns of row.
            // check if element exists
            if (colIndexList.get(i) == column) {
                valueList.set(i, value);
                return;
            }
        }
        for (int i = row; i < numberOfRows + 1; i++) {
            rowIndexList.set(i, rowIndexList.get(i) + 1); // increase number of elements
        }
        
        colIndexList.add(rowIndexList.get(row - 1), column);
        valueList.add(rowIndexList.get(row - 1), value);
    }

    public Matrix toMatrix() {
        Matrix matrix = new Matrix();
        matrix.setColIndexList(colIndexList);
        matrix.setRowIndexList(rowIndexList);
        matrix.setValueList(valueList);
        matrix.setNumberOfColumns(numberOfColumns);
        matrix.setNumberOfRows(numberOfRows);
        matrix.setNumberOfElements(numberOfElements);
        return matrix;
    }
}
