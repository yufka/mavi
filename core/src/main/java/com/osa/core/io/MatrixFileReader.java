package com.osa.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Interface for File Readers
 * 
 * @author oleksii
 * @since Jul 22, 2020
 */
public abstract class MatrixFileReader implements AutoCloseable {
    
    /**
     * String contains path to file of matrix.
     */
    protected final String fileName;
    
    protected BufferedReader bufferedReader;
    
    protected MatrixFileReader(final String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("fileName is null or empty");
        }
        bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
    }
    
    /**
     * This method in file reader should be used to iterate over values of the matrix.
     * Each call returns an new entry from matrix until End of File.
     * 
     * @return next matrix entry from file, or {@code null} in case if end of file is reached.
     */
    public abstract MatrixEntry getEntry();
    
    public abstract MatrixFileMetadata getMetadata();
    
    /**
     * This function can be used by matrix readers to split string into words.
     * 
     * @param line string line
     * @return array of words from string, or {@code null} if string is not initialized.
     */
    protected String[] splitOnWhiteSpaces(final String line) {
        if (line != null) {
            return line.trim().split("\\s+");
        }
        return null;
    }
    
    @Override
    public void close() throws IOException {
        if (this.bufferedReader != null) {
            this.bufferedReader.close();
        }
    }
}
