package com.osa.mavi.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class contains information about matrix size, number of elements,
 * type of matrix, type of matrix file (coordinate, array) etc.
 * 
 * @author oleksii
 * @since Mar 11, 2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatrixFileMetadata {

    private int numberOfRows;

    private int numberOfColumns;

    private int numberOfNonzeroElements;

    private boolean symmetric;

    private String type;
}
