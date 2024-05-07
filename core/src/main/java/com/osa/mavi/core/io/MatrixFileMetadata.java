package com.osa.mavi.core.io;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class contains information about matrix size, number of elements,
 * type of matrix, type of matrix file (coordinate, array) etc.
 * 
 * @author oleksii
 * @since Mar 11, 2021
 */

@Data
@AllArgsConstructor
public class MatrixFileMetadata {

    private int numberOfRows;
    
    private int numberOfColumns;
    
    private int numberOfElements;
    
    private boolean symmetric;
    
    private String type;
    
    private String header;
}
