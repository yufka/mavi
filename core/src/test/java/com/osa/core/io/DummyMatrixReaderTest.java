package com.osa.core.io;

import com.osa.core.image.MatrixPortrait;
import com.osa.core.matrix.Matrix;
import org.junit.Test;

/**
 *
 * @author oleksii
 * @since Dec 25, 2020
 */
public class DummyMatrixReaderTest {
    
    private static final String FILE_PATH = "/Users/oleksii/Documents/Projects/mavi/matrix/test_dummy.mtx";
    
    private static final String FILE_PATH_2 = "/Users/oleksii/Documents/Projects/mavi/matrix/test_dummy_large.mtx";

    @Test
    public void readMatrixTest() {
        try {
            Matrix m = new DummyMatrixReader().read(FILE_PATH);
            System.out.println(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void readMatrixTest1() {
        try {
            Matrix m = new DummyMatrixReader().read(FILE_PATH_2);
            System.out.println(m);
            new MatrixPortrait.Builder(m.getNumberOfRows(), m.getNumberOfColumns()).build(m).saveTo("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
