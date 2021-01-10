package com.osa.core.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a sparse matrix read from a CSR file.
 * 
 * @author alex.saukh@gmail.com
 * @since Jul 22, 2020
 */
public class Matrix {
    
    /**
     * Number of rows in the matrix
     */
    private int numberOfRows;
    
    /**
     * Number of columns in the matrix
     */
    private int numberOfColumns;
    
    /**
     * Number of non-zero elements in the matrix
     */
    private int numberOfElements;
    
    /**
     * Row index list
     */
    private List<Integer> rowIndexList;
    
    /**
     * Column index list
     */
    private List<Integer> colIndexList;
    
    /**
     * List of values in the matrix
     */
    private List<Double> valueList;
    
    public void reinit() {
        rowIndexList = new ArrayList<>(numberOfRows + 1);
        rowIndexList.add(0); // set initial 0
        colIndexList = new ArrayList<>(numberOfElements);
        valueList = new ArrayList<>(numberOfElements);
    }

    public List<Integer> getRowIndexList() {
        return rowIndexList;
    }

    public void setRowIndexList(List<Integer> rowIndexList) {
        this.rowIndexList = rowIndexList;
    }

    public List<Integer> getColIndexList() {
        return colIndexList;
    }

    public void setColIndexList(List<Integer> colIndexList) {
        this.colIndexList = colIndexList;
    }

    public List<Double> getValueList() {
        return valueList;
    }

    public void setValueList(List<Double> valueList) {
        this.valueList = valueList;
    }

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

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rows : ").append(numberOfRows).append("/n");
        sb.append("Cols : ").append(numberOfColumns).append("/n");
        sb.append("NNZ  : ").append(numberOfElements).append("/n");
        sb.append("RowIndex: [");
        this.rowIndexList.forEach(i -> {
            sb.append(i).append(" ");
        });
        
        sb.append("]/n");
        sb.append("ColIndex: [");
        this.colIndexList.forEach(i -> {
            sb.append(i).append(" ");
        });
        
        sb.append("]/n");
        sb.append("Values: [");
        this.valueList.forEach(i -> {
            sb.append(i).append(" ");
        });
        
        sb.append("]/n");
        return sb.toString();
    }
}
