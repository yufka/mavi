package com.osa.mavi.core.io;

/**
 * Class contains information about matrix size, number of elements,
 * type of matrix, type of matrix file (coordinate, array) etc.
 * 
 * @author oleksii
 * @since Mar 11, 2021
 */
public class MatrixFileMetadata {

    private int numberOfRows;
    
    private int numberOfColumns;
    
    private int numberOfElements;
    
    private boolean symetric;
    
    private String type;
    
    private String header;
    
    public MatrixFileMetadata(int rows, int columns, int nnz, boolean symetrix, String type, String header) {
        this.numberOfRows = rows;
        this.numberOfColumns = columns;
        this.numberOfElements = nnz;
        this.symetric = symetrix;
        this.type = type;
        this.header = header;
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

    public boolean isSymetric() {
        return symetric;
    }

    public void setSymetric(boolean symetric) {
        this.symetric = symetric;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    
    @Override
    public String toString() {
        return "MatrixFileMetadata{" 
                + "numberOfRows=" + numberOfRows 
                + ", numberOfColumns=" + numberOfColumns 
                + ", numberOfElements=" + numberOfElements 
                + ", symetric=" + symetric 
                + ", type=" + type 
                + ", header=" + header 
                + '}';
    }
}
