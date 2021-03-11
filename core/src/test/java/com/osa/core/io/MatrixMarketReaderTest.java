package com.osa.core.io;

import com.osa.core.io.reader.MatrixEntry;
import com.osa.core.io.reader.MatrixFileMetadata;
import com.osa.core.io.reader.MatrixFileReader;
import com.osa.core.io.reader.MatrixMarketReader;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author oleksii
 * @since Mar 11, 2021
 */
public class MatrixMarketReaderTest {
    
    private static final String MM_FILE_PATH = "/Users/oleksii/Documents/Projects/mavi/matrix/fidap005.mtx";

    @Test
    public void testReader() throws IOException {
        MatrixFileReader reader = new MatrixMarketReader(MM_FILE_PATH);
        MatrixFileMetadata meta = reader.getMetadata();
        System.out.println(meta);
        MatrixEntry entry;
        while ((entry = reader.getEntry()) != null) {
            System.out.println(entry);
        }
    }
}
