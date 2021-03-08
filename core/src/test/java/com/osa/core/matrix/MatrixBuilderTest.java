package com.osa.core.matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author oleksii
 * @since Mar 8, 2021
 */
public class MatrixBuilderTest {

    @Test
    public void testMatrixBuilder1x1() {
        MatrixBuilder builder = new MatrixBuilder(1,1,1);
        builder.insertElement(1, 1, 2.0d);
        Matrix matrix = builder.toMatrix();
        Assert.assertEquals(1, matrix.getNumberOfColumns());
        Assert.assertEquals(1, matrix.getNumberOfRows());
        Assert.assertEquals(1, matrix.getNumberOfElements());
        Assert.assertEquals((Double) 2.0, matrix.getValueList().get(0));
    }
    
    @Test
    public void testMatrixBuilder3x5() {
        MatrixBuilder builder = new MatrixBuilder(3, 5, 8);
        builder.insertElement(1, 1, 1.0);
        builder.insertElement(1, 3, 2.0);
        builder.insertElement(1, 4, 3.0);
        
        builder.insertElement(2, 3, 4.0);
        builder.insertElement(2, 4, 5.0);
        builder.insertElement(2, 5, 6.0);
        
        builder.insertElement(3, 1, 7.0);
        builder.insertElement(3, 5, 8.0);
        Matrix matrix = builder.toMatrix();
        Assert.assertEquals(3, matrix.getNumberOfRows());
        Assert.assertEquals(5, matrix.getNumberOfColumns());
        Assert.assertEquals(8, matrix.getNumberOfElements());
        System.out.println(matrix);
        Assert.assertArrayEquals(new Integer[]{0, 3, 6, 8}, matrix.getRowIndexList().toArray());
        Assert.assertArrayEquals(new Integer[]{4, 3, 1, 5, 4, 3, 5, 1}, matrix.getColIndexList().toArray());
        Assert.assertArrayEquals(new Double[]{3.0d, 2.0d, 1.0d, 6.0d, 5.0d, 4.0d, 8.0d, 7.0d}, matrix.getValueList().toArray());
    }
}
