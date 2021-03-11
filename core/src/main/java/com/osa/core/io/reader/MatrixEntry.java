package com.osa.core.io.reader;

/**
 * Class represents a single element of the matrix from input file.
 * 
 * @author oleksii
 * @since Mar 11, 2021
 */
public class MatrixEntry {

    private int row;

    private int column;
    
    private double value;
    
    public MatrixEntry(int row, int column, double value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "MatrixEntry{" + "row=" + row + ", column=" + column + ", value=" + value + '}';
    }
}
