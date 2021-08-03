package com.osa.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import org.apache.log4j.Logger;

/**
 * This class read files of MatrixMarket type described in Matrix Market
 * {@see <a href="https://math.nist.gov/MatrixMarket/formats.html">Martix Market</a>}
 * {@see <a href="https://math.nist.gov/MatrixMarket/reports/MMformat.ps">The Martix Market Exchange Formas: Initial
 * Design</a>}
 *
 * @author oleksii
 * @since Mar 3, 2021
 */
public class MatrixMarketReader extends MatrixFileReader {
    
    private static final String SERVICE = MatrixMarketReader.class.getName();
    
    private static final Logger LOGGER = Logger.getLogger("");

    /**
     * First Line in Matrix Market should start with this String.
     */
    private static final String MM_MARKER = "%%MatrixMarket ";
    
    private int numberOfRows;

    private int numberOfColumns;

    private int numberOfElements;

    private boolean isSymetric;

    private String type;

    private String header;

    private boolean isMatrix;

    private boolean isCoordinate;

    public MatrixMarketReader(final String fileName) throws FileNotFoundException, IOException {
        super(fileName);
        header = bufferedReader.readLine().trim();
        parseMatrixHeader(header);
        boolean readDimentions = false;
        while (true) {
            if (readDimentions == true) {
                break;
            }
            String line = bufferedReader.readLine().trim();
            readDimentions = parseMatrixDimentions(line);
        }
    }

    @Override
    public MatrixEntry getEntry() {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim().toLowerCase(Locale.ROOT);
                if (line.isEmpty() || line.startsWith("%")) {
                    continue; // skip comments
                }
                String[] splits = splitOnWhiteSpaces(line);
                if (splits.length != 3) {
                    throw new IllegalArgumentException("Line with wrong number of elements: expected 3 but got: "
                            + splits.length);
                }
                return new MatrixEntry(Integer.valueOf(splits[0]) - 1, Integer.valueOf(splits[1]) - 1,
                        Double.valueOf(splits[2]));
            }
        } catch (IOException | IllegalArgumentException e) {
            LOGGER.error(SERVICE, e);
        }
        return null;
    }

    @Override
    public MatrixFileMetadata getMetadata() {
        return new MatrixFileMetadata(numberOfRows, numberOfColumns, numberOfElements, isSymetric, type, header);
    }

    private void parseMatrixHeader(String header) {
        if (header == null || header.isEmpty() || !header.startsWith(MM_MARKER)) {
            throw new IllegalArgumentException("First line does not correspond to Matrix Market format.");
        }
        header = header.substring(MM_MARKER.length());
        String[] splits = header.split("\\s+");
        try {
            if (splits.length > 1) {
                String object = splits[0].toLowerCase(Locale.ROOT);
                isMatrix = "matrix".equals(object) || "vector".equals(object);

                String formatType = splits[1].toLowerCase(Locale.ROOT);
                isCoordinate = "coordinate".equals(formatType);
                for (int i = 2; i < splits.length; i++) {
                    String symetricProperty = splits[i].toLowerCase(Locale.ROOT);
                    if ("symetric".equals(symetricProperty)) {
                        isSymetric = true;
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

    private boolean parseMatrixDimentions(String line) {
        line = line.trim().toLowerCase(Locale.ROOT);
        if (line.isEmpty() || line.startsWith("%")) {
            return false;
        }
        String[] splits = splitOnWhiteSpaces(line);
        if (splits.length != 3) {
            return false;
        }
        numberOfRows = Integer.valueOf(splits[0]);
        numberOfColumns = Integer.valueOf(splits[1]);
        numberOfElements = Integer.valueOf(splits[2]);
        return true;
    }

    private MatrixEntry parseMatrixEntry(String line) {
        if (line != null) {
            line = line.trim().toLowerCase(Locale.ROOT);
            if (!line.isEmpty() && !line.startsWith("%")) {
                String[] splits = splitOnWhiteSpaces(line);
                if (splits.length == 3) {
                    return new MatrixEntry(Integer.valueOf(splits[0]), Integer.valueOf(splits[1]),
                            Double.valueOf(splits[2]));
                }
            }
        }
        return null;
    }
}