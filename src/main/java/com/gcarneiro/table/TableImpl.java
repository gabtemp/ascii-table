package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
import com.gcarneiro.table.api.Column;
import com.gcarneiro.table.api.Table;

import java.util.List;

/**
 * A table that resolver its cell values from an object's properties (using reflection).
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class TableImpl implements Table {

    private List<Column> columns;

    private List<?> rows;

    private int[] lengthPerColumn;

    private String[] header;

    private String[][] data;

    protected TableImpl() {
    }

    // TODO: Consider the column alignment
    public String renderTable() {
        populateData();
        StringBuilder tableString = new StringBuilder();

        createHeader(tableString);
        for (String[] row : data) {
            for (int columnId = 0; columnId < data[0].length; columnId++) {
                String string = row[columnId];
                String cell = Alignment.LEFT.padString(string, lengthPerColumn[columnId]);

                tableString.append("| ");
                tableString.append(cell);
                tableString.append(" ");
                if (columnId == data[0].length - 1) {
                    tableString.append(" |");
                }
            }
            tableString.append("\n");
        }
        createSeparator(tableString);
        return tableString.toString();
    }

    private void createHeader(StringBuilder tableString) {
        createSeparator(tableString);
        for (int columnId = 0; columnId < header.length; columnId++) {
            String string = header[columnId];
            String cell = Alignment.LEFT.padString(string, lengthPerColumn[columnId]);

            tableString.append("| ");
            tableString.append(cell);
            tableString.append(" ");
            if (columnId == header.length - 1) {
                tableString.append(" |");
            }
        }
        tableString.append("\n");
        createSeparator(tableString);
    }

    private void createSeparator(StringBuilder tableString) {
        for (int i : lengthPerColumn) {
            tableString.append("+");
            tableString.append(repeat(i + 2, "-"));
        }
        tableString.append("-+");
        tableString.append("\n");
    }

    private void populateData() {
        lengthPerColumn = new int[columns.size()];
        header = new String[columns.size()];
        data = new String[rows.size()][columns.size()];

        for (int columnId = 0; columnId < columns.size(); columnId++) {
            String columnName = columns.get(columnId).getColumnName();
            header[columnId] = columnName;

            updateColumnLength(columnId, columnName.length());
        }

        for (int rowId = 0; rowId < rows.size(); rowId++) {
            Object row = rows.get(rowId);
            for (int columnId = 0; columnId < columns.size(); columnId++) {
                Column column = columns.get(columnId);

                String rowValue = column.getRowValue(row);
                data[rowId][columnId] = rowValue;

                updateColumnLength(columnId, rowValue.length());
            }
        }
    }

    private void updateColumnLength(int columnId, int newLength) {
        if (lengthPerColumn[columnId] < newLength) {
            lengthPerColumn[columnId] = newLength;
        }
    }

    private String repeat(int n, String s) {
        return new String(new char[n]).replace("\0", s);
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
