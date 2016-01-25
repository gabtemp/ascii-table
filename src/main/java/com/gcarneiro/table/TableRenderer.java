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
        StringBuilder headerBuilder = createHeader(header, lengthPerColumn);
        StringBuilder dataBuilder = createData(data, lengthPerColumn);

        tableString.append(separatorBuilder);
        tableString.append(headerBuilder);
        tableString.append(separatorBuilder);
        tableString.append(dataBuilder);
        tableString.append(separatorBuilder);

        return tableString.toString();
    }

    private static StringBuilder createHeader(String[] header, int[] lengthPerColumn) {
        StringBuilder headerBuilder = new StringBuilder();
        for (int columnId = 0; columnId < header.length; columnId++) {
            String string = header[columnId];
            String cell = Alignment.LEFT.padString(string, lengthPerColumn[columnId]);

            headerBuilder.append("| ");
            headerBuilder.append(cell);
            headerBuilder.append(" ");
            if (columnId == header.length - 1) {
                headerBuilder.append("|");
            }
        }
        headerBuilder.append("\n");
        return headerBuilder;
    }

    private static StringBuilder createData(String[][] data, int[] lengthPerColumn) {
        StringBuilder dataBuilder = new StringBuilder();
        for (String[] row : data) {
            for (int columnId = 0; columnId < data[0].length; columnId++) {
                String string = row[columnId];
                String cell = Alignment.LEFT.padString(string, lengthPerColumn[columnId]);

                dataBuilder.append("| ");
                dataBuilder.append(cell);
                dataBuilder.append(" ");
                if (columnId == data[0].length - 1) {
                    dataBuilder.append("|");
                }
            }
            dataBuilder.append("\n");
        }
        return dataBuilder;
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
