package com.osa.mavi.code.io;

import com.osa.mavi.core.io.MatrixReaderUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixReaderUtilsTest {

    private static Stream<Arguments> getHeaderStringsForTest() {
        return Stream.of(
                Arguments.of("Some non-mm file header", false),
                Arguments.of("%Some commented non-mm file header", false),
                Arguments.of("%%MatrixMarket", false),
                Arguments.of("%%%%MatrixMarket too many %", false),
                Arguments.of(" %%%%MatrixMarket too many %", false),
                Arguments.of("%%MatrixMarket proper header", true),
                Arguments.of("%%MatrixMarket matrix coordinate real general", true)
        );
    }

    @ParameterizedTest
    @MethodSource("getHeaderStringsForTest")
    void isMatrixMarketFirstLine(String headerLine, boolean result) {
        assertEquals(result, MatrixReaderUtils.isMatrixMarketFirstLine(headerLine));
    }
}
