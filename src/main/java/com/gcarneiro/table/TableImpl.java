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

    List<Column> columns;

    List<?> rows;
    private int[] lengthPerColumn;

    protected TableImpl() {
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    // TODO: Consider the column alignment
    public String renderTable() {
        String[][] tableData = populateMatrix();
        StringBuilder tableString = new StringBuilder();

        for (String[] row : tableData) {
            for (int columnId = 0; columnId < tableData[0].length; columnId++) {
                String string = row[columnId];
                String cell = Alignment.LEFT.padString(string, lengthPerColumn[columnId]);
                tableString.append(cell);
                tableString.append(" | ");
            }
            tableString.append("\n");
        }
        return tableString.toString();
    }

    private String[][] populateMatrix() {
        lengthPerColumn = new int[columns.size()];
        String[][] matrix = new String[rows.size() + 1][columns.size()];

        for (int columnId = 0; columnId < columns.size(); columnId++) {
            String columnName = columns.get(columnId).getColumnName();
            matrix[0][columnId] = columnName;

            updateColumnLength(columnId, columnName.length());
        }

        for (int rowId = 0; rowId < rows.size(); rowId++) {
            Object row = rows.get(rowId);
            for (int columnId = 0; columnId < columns.size(); columnId++) {
                Column column = columns.get(columnId);

                String rowValue = column.getRowValue(row);
                matrix[rowId + 1][columnId] = rowValue;

                updateColumnLength(columnId, rowValue.length());
            }
        }

        return matrix;
    }

    private void updateColumnLength(int columnId, int newLength) {
        if (lengthPerColumn[columnId] < newLength) {
            lengthPerColumn[columnId] = newLength;
        }
    }
}
