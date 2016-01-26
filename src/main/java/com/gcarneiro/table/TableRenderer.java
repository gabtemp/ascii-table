package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;

/**
 * @author gabriel.carneiro
 * @since 25/01/16.
 */
public final class TableRenderer {

    private TableRenderer() {
    }

    public static String renderTable(String[] header, String[][] data, int[] lengthPerColumn) {
        StringBuilder tableString = new StringBuilder();

        StringBuilder separatorBuilder = createSeparator(lengthPerColumn);
        StringBuilder headerBuilder = createRow(header, lengthPerColumn);
        StringBuilder dataBuilder = createData(data, lengthPerColumn);

        tableString.append(separatorBuilder);
        tableString.append(headerBuilder);
        tableString.append(separatorBuilder);
        tableString.append(dataBuilder);
        tableString.append(separatorBuilder);

        return tableString.toString();
    }

    private static StringBuilder createData(String[][] data, int[] lengthPerColumn) {
        StringBuilder dataBuilder = new StringBuilder();
        for (String[] row : data) {
            dataBuilder.append(createRow(row, lengthPerColumn));
        }
        return dataBuilder;
    }

    private static StringBuilder createRow(String[] header, int[] lengthPerColumn) {
        StringBuilder rowBuilder = new StringBuilder();
        for (int columnId = 0; columnId < header.length; columnId++) {
            String value = header[columnId];
            boolean lastColumn = columnId == header.length - 1;
            rowBuilder.append(printCell(value, lengthPerColumn[columnId], lastColumn));
        }
        rowBuilder.append("\n");
        return rowBuilder;
    }

    private static StringBuilder printCell(String value, int cellLength, boolean lastCell) {
        StringBuilder cellBuilder = new StringBuilder();
        //TODO: Consider column alignment
        String cell = Alignment.LEFT.padString(value, cellLength);
        cellBuilder.append("| ");
        cellBuilder.append(cell);
        cellBuilder.append(" ");
        if (lastCell) {
            cellBuilder.append("|");
        }
        return cellBuilder;
    }

    private static StringBuilder createSeparator(int[] lengthPerColumn) {
        StringBuilder separatorBuilder = new StringBuilder();
        for (int i : lengthPerColumn) {
            separatorBuilder.append("+");
            separatorBuilder.append(repeat(i + 2, "-"));
        }
        separatorBuilder.append("+");
        separatorBuilder.append("\n");
        return separatorBuilder;
    }

    private static String repeat(int n, String s) {
        return new String(new char[n]).replace("\0", s);
    }
}
