package com.osa.mavi.core.io;

import com.osa.mavi.core.model.MatrixEntry;
import com.osa.mavi.core.model.MatrixFileMetadata;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Abstract class File Readers
 * 
 * @author oleksii
 * @since Jul 22, 2020
 */
@Slf4j
@Getter
public abstract class MatrixFileReader implements AutoCloseable {

    protected int numberOfRows;
    protected int numberOfColumns;
    protected int numberOfElements;
    protected final String fileName;
    protected BufferedReader bufferedReader;
    
    protected MatrixFileReader(final String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        if (fileName == null || fileName.isEmpty()) {
            log.error("fileName is null or empty");
            throw new IllegalArgumentException("fileName is null or empty");
        }
        bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
        log.debug("Opened matrix file : " + fileName);
    }
    
    /**
     * This method in file reader should be used to iterate over values of the matrix.
     * Each call returns an new entry from matrix until End of File.
     * 
     * @return next matrix entry from file, or {@code null} in case if end of file is reached.
     */
    public abstract MatrixEntry getEntry();
    
    public abstract MatrixFileMetadata getMetadata();


    @Override
    public void close() throws IOException {
        if (this.bufferedReader != null) {
            this.bufferedReader.close();
        }
    }
}
