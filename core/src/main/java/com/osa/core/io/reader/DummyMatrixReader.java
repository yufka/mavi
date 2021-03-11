package com.osa.core.io.reader;

import java.io.FileNotFoundException;

/**
 * Read dummy matrix file. Used for tests. File structure is simple: - first row
 * contains number of columns - second row contains number of rows - third row
 * contains number of nonzero elements - all other rows contain comma-separated
 * values of the matrix.
 *
 * @author oleksii
 * @since Jul 29, 2020
 */
public class DummyMatrixReader extends MatrixFileReader {
    
    public DummyMatrixReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    @Override
    public MatrixEntry getEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixFileMetadata getMetadata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Matrix read(String fileName) throws Exception {
//        if (fileName == null || fileName.isEmpty()) {
//            throw new IllegalArgumentException("filename is null or empty");
//        }
//        Matrix matrix = new Matrix();
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
//            matrix.setNumberOfRows(Integer.valueOf(reader.readLine()));
//            matrix.setNumberOfColumns(Integer.valueOf(reader.readLine()));
//            matrix.setNumberOfElements(Integer.valueOf(reader.readLine()));
//            matrix.reinit();
//            String line = null;
//            int rowNumber = 0;
//            while ((line = reader.readLine()) != null) {
//                importNewRowToMatrix(matrix, line, rowNumber++);
//            }
//        }
//        return matrix;
//    }
//
//    private void importNewRowToMatrix(Matrix matrix, final String row, final int rowNumber) {
//        final String[] splits = row.split(" ");
//        matrix.getRowIndexList().add(matrix.getRowIndexList().get(rowNumber));
//        if (splits == null || splits.length == 0) {
//            return; // nothing to do
//        }
//        for (int i = 0; i < splits.length; i++) {
//            double value = Double.valueOf(splits[i]);
//            if (value != .0) {
//                // increase nonzeroes
//                matrix.getRowIndexList()
//                        .set(rowNumber + 1, matrix.getRowIndexList().get(rowNumber + 1) + 1);
//                matrix.getColIndexList().add(i);
//                matrix.getValueList().add(value);
//            }
//        }
//    }
}
