package com.osa.mavi.core.io;

public class MatrixReaderUtils {

    private static final String MM_MARKER = "%%MatrixMarket ";

    private static final String MM_COMMENT = "%";

    private static final String MATRIX_STRING = "matrix";

    private static final String VECTOR_STRING = "vector";

    private static final String COORDINATE_STRING = "coordinate";

    private static final String SYMMETRIC_STRING = "symmetric";

    public static String[] splitOnWhiteSpaces(final String line) {
        if (line != null) {
            return line.trim().split("\\s+");
        }
        return null;
    }

    public static String getWithoutHeaderPrefix(final String line) {
        return line.substring(MM_MARKER.length());
    }

    public static boolean isMatrixMarketFirstLine(final String line) {
        return startsWith(line, MM_MARKER);
    }

    public static boolean isMatrixMarketComment(final String line) {
        return startsWith(line, MM_COMMENT);
    }

    private static boolean startsWith(final String line, final String prefix) {
        return line != null && line.startsWith(prefix);
    }

    public static boolean isMatrix(final String line) {
        return stringEquals(line, MATRIX_STRING);
    }

    public static boolean isVector(final String line) {
        return stringEquals(line, VECTOR_STRING);
    }

    private static boolean stringEquals(final String line, final String expected) {
        return expected.equalsIgnoreCase(line);
    }
}
