package com.osa.core.io.reader;

import com.osa.core.matrix.Matrix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author oleksii
 * @since Jul 22, 2020
 */
public class CSRFileReader implements MatrixFileReader {

    @Override
    public Matrix read(String fileName) throws Exception {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("filename is null or empty");
        }
        Matrix matrix = new Matrix();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.startsWith("%")) {
                    continue; // skip comments
                }
                // read n,m,nnz
                String[] vals = line.split(" ");
                matrix.setNumberOfRows(Integer.parseInt(vals[0]));
                matrix.setNumberOfColumns(Integer.parseInt(vals[1]));
                matrix.setNumberOfElements(Integer.parseInt(vals[2]));
                System.out.println("Read data: "
                        + matrix.getNumberOfRows()
                        + " " + matrix.getNumberOfColumns()
                        + " "+ matrix.getNumberOfElements());
                break;
            }    
            for (long i = 0; i < matrix.getNumberOfElements(); i++) {
                String line = reader.readLine();
                String[] vals = line.split(" ");
                if (vals.length != 3) {
                    throw new IllegalArgumentException("Row does not contain 3 elements, but " + vals.length);
                }
                // now add values to matrix
                
            }
            return matrix;
        }
    }
}
