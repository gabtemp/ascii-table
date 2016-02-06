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
public class TableImpl<T> implements Table<T> {

    private List<? extends Column> columns;

    private List<T> rows;

    private int[] lengthPerColumn;

    private Alignment[] alignments;

    private String[] header;

    private String[][] data;

    protected TableImpl() {
    }

    public String renderTable() {
        populateData();
        return TableRenderer.renderTable(header, data, lengthPerColumn, alignments);
    }

    private void populateData() {
        lengthPerColumn = new int[columns.size()];
        alignments = new Alignment[columns.size()];
        header = new String[columns.size()];
        data = new String[rows.size()][columns.size()];

        for (int columnId = 0; columnId < columns.size(); columnId++) {
            String columnName = columns.get(columnId).getColumnName();
            header[columnId] = columnName;

            updateColumnLength(columnId, columnName.length());
            alignments[columnId] = columns.get(columnId).getColumnAlignment();
        }

        for (int rowId = 0; rowId < rows.size(); rowId++) {
            T row = rows.get(rowId);
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

    public void setColumns(List<? extends Column> columns) {
        this.columns = columns;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
