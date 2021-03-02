package com.osa.core.io.reader;

import com.osa.core.matrix.Matrix;

/**
 * Interface for FileReaders
 * 
 * @author oleksii
 * @since Jul 22, 2020
 */
public interface MatrixFileReader {

    /**
     * Read matrix from file. 
     * 
     * @param fileName name of matrix file
     * @return Matrix object containing matrix read from file
     * @throws Exception  in case if data could not be read
     */
    Matrix read(String fileName) throws Exception;
}
