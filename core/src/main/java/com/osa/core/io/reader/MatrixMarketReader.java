package com.osa.core.io.reader;

import com.osa.core.matrix.Matrix;
import com.osa.core.matrix.MatrixBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.IllegalFormatException;
import java.util.Locale;
import javax.tools.StandardLocation;

/**
 * This class read files of MatrixMarket type described in Matrix Market
 * {@see <a href="https://math.nist.gov/MatrixMarket/formats.html">Martix Market</a>}
 * {@see <a href="https://math.nist.gov/MatrixMarket/reports/MMformat.ps">The Martix Market Exchange Formas:
 * Initial Design</a>}
 * 
 * @author oleksii
 * @since Mar 3, 2021
 */
public class MatrixMarketReader implements MatrixFileReader {
    
    private static final String MM_MARKER = "%%MatrixMarket";

    @Override
    public Matrix read(String fileName) throws Exception {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("filename is null or empty");
        }
        MatrixBuilder builder = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String header = reader.readLine().trim();
            // TODO: process header line
            String line;
            
            boolean readMatrixDimentions = false;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                if (line.startsWith("%")) {
                    continue; // skip comments.
                }
                line = line.trim().toLowerCase(Locale.ROOT);
                
                if (!readMatrixDimentions) {
                    String[] dimentions = line.split(" ");
                    if (dimentions.length != 3) {
                        throw new IllegalStateException("File does not contain matrix dimention string.");
                    }
                    builder = new MatrixBuilder(
                            Integer.valueOf(dimentions[0]),
                            Integer.valueOf(dimentions[1]), 
                            Integer.valueOf(dimentions[2]));
                    readMatrixDimentions = true;
                } else {
                    if (builder == null) {
                        throw new IllegalStateException("Matrix bouilder could not be initialized");
                    }
                    // read values
                    String[] dimentions = line.trim().split("\\s+");
                    builder.insertElement(Integer.valueOf(dimentions[0]), Integer.valueOf(dimentions[1]),
                            Double.parseDouble(dimentions[2]));
                }
                
            }
            return builder.toMatrix();
        }
    }
}
