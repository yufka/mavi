package com.osa.mavi.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class represents a single element of the matrix.
 *
 * @author oleksii
 * @since Mar 11, 2021
 */
@Data
@AllArgsConstructor
public class MatrixEntry {
    private int row;
    private int column;
    private double value;
}
