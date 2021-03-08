package com.osa.core.io;

import com.osa.core.io.reader.DummyMatrixReader;
import com.osa.core.io.reader.MatrixMarketReader;
import com.osa.core.protrait.image.BufferedImageWriter;
import com.osa.core.matrix.Matrix;
import com.osa.core.processor.PortraitBuilder;
import com.osa.core.processor.palette.BasicPalette;
import com.osa.core.processor.strategy.StrategyName;
import com.osa.core.protrait.Portrait;
import com.osa.core.protrait.PortraitToImageTransformer;
import org.junit.Test;

/**
 *
 * @author oleksii
 * @since Dec 25, 2020
 */
public class DummyMatrixReaderTest {
    
    private static final String FILE_PATH = "/Users/oleksii/Documents/Projects/mavi/matrix/test_dummy.mtx";
    
    private static final String FILE_PATH_2 = "/Users/oleksii/Documents/Projects/mavi/matrix/test_dummy_large.mtx";
    
    private static final String MM_FILE_PATH = "/Users/oleksii/Documents/Projects/mavi/matrix/fidap005.mtx";
    
    @Test
    public void readMatrixTest1() {
        try {
            Matrix m = new DummyMatrixReader().read(FILE_PATH_2);
            System.out.println(m);
            PortraitBuilder builder = new PortraitBuilder(4, 6, StrategyName.MID_AVG_VAL);
            Portrait portrait = builder.build(m);
            new BufferedImageWriter(new PortraitToImageTransformer(new BasicPalette()).getImage(portrait)).saveTo("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void readMatrixMMTest() {
        try {
            Matrix m = new MatrixMarketReader().read(MM_FILE_PATH);
            PortraitBuilder builder = new PortraitBuilder(100, 100, StrategyName.MID_AVG_VAL);
            Portrait portrait = builder.build(m);
            new BufferedImageWriter(new PortraitToImageTransformer(new BasicPalette()).getImage(portrait)).saveTo("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
