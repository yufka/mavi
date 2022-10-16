package com.osa.mavi.controller;

import java.io.Serializable;

/**
 *
 * @author oleksii
 * @since Oct 14, 2022
 */
public class MatrixStats implements Serializable {

    private int numberOfRows;
    
    private int numberOfColumns;
    
    private int numberOfNonzeroes;
    
    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfNonzeroes() {
        return numberOfNonzeroes;
    }

    public void setNumberOfNonzeroes(int numberOfNonzeroes) {
        this.numberOfNonzeroes = numberOfNonzeroes;
    }
}
