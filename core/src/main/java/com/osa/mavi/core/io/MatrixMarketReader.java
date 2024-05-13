package com.osa.mavi.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import com.osa.mavi.core.model.MatrixEntry;
import com.osa.mavi.core.model.MatrixFileMetadata;
import lombok.extern.slf4j.Slf4j;

/**
 * This class read files of MatrixMarket type described in Matrix Market
 * {@see <a href="https://math.nist.gov/MatrixMarket/formats.html">Martix Market</a>}
 * {@see <a href="https://math.nist.gov/MatrixMarket/reports/MMformat.ps">The Martix Market Exchange Formas: Initial
 * Design</a>}
 *
 * @author oleksii
 * @since Mar 3, 2021
 */
@Slf4j
public class MatrixMarketReader extends MatrixFileReader {

    private boolean isSymmetric;

    private String type;

    private boolean isMatrix;

    private boolean isCoordinate;

    public MatrixMarketReader(final String fileName) throws FileNotFoundException, IOException {
        super(fileName);
        parseMatrixHeader(bufferedReader.readLine().trim());
        boolean readDimensions = false;
        while (true) {
            if (readDimensions == true) {
                break;
            }
            readDimensions = parseMatrixDimensions(bufferedReader.readLine().trim().toLowerCase(Locale.ROOT));
        }
    }

    @Override
    public MatrixEntry getEntry() {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim().toLowerCase(Locale.ROOT);
                if (MatrixReaderUtils.isMatrixMarketComment(line)) {
                    continue;
                }
                String[] splits = MatrixReaderUtils.splitOnWhiteSpaces(line);
                if (splits.length != 3) {
                    throw new IllegalArgumentException("Line with wrong number of elements: expected 3 but got: "
                            + splits.length);
                }
                return new MatrixEntry(Integer.valueOf(splits[0]) - 1, Integer.valueOf(splits[1]) - 1,
                        Double.valueOf(splits[2]));
            }
        } catch (IOException | IllegalArgumentException e) {
            log.error("Failed to extract entry", e);
        }
        return null;
    }

    @Override
    public MatrixFileMetadata getMetadata() {
        return new MatrixFileMetadata(numberOfRows, numberOfColumns, numberOfElements, isSymmetric, type);
    }

    private void parseMatrixHeader(String header) {
        if (!MatrixReaderUtils.isMatrixMarketFirstLine(header)) {
            throw new IllegalArgumentException("First line does not correspond to Matrix Market format.");
        }
        header = MatrixReaderUtils.getWithoutHeaderPrefix(header);
        String[] splits = MatrixReaderUtils.splitOnWhiteSpaces(header);

        try {
            if (splits.length > 1) {

                String matrixDimention = splits[0].toLowerCase(Locale.ROOT);
                isMatrix = MatrixReaderUtils.isMatrix(matrixDimention) || MatrixReaderUtils.isVector(matrixDimention);

                String formatType = splits[1].toLowerCase(Locale.ROOT);
                isCoordinate = "coordinate".equals(formatType);

                for (int i = 2; i < splits.length; i++) {
                    if ("symmetric".equals(splits[i].toLowerCase(Locale.ROOT))) {
                        isSymmetric = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Can not parse header string");
        }
        if (!isMatrix || !isCoordinate) {
            throw new IllegalArgumentException("Can not read matrix.");
        }
    }

    private boolean parseMatrixDimensions(String line) {
        if (MatrixReaderUtils.isMatrixMarketComment(line)) {
            return false;
        }
        String[] splits = MatrixReaderUtils.splitOnWhiteSpaces(line);
        if (splits.length != 3) {
            log.error("Failed to parse matrix dimentions from string : " + line);
            return false;
        }
        numberOfRows = Integer.valueOf(splits[0]);
        numberOfColumns = Integer.valueOf(splits[1]);
        numberOfElements = Integer.valueOf(splits[2]);
        return true;
    }
}