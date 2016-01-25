package com.gcarneiro.table;

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

    // TODO: Consider the column size and alignment
    public String renderTable() {
        StringBuilder tableString = new StringBuilder();
        tableString.append("| ");
        for (Column column : columns) {
            tableString.append(column.getColumnName());
            tableString.append(" | ");
        }
        tableString.append("\n");

        for (Object row : rows) {
            tableString.append("| ");
            for (Column column : columns) {
                tableString.append(column.getRowValue(row));
                tableString.append(" | ");
            }
            tableString.append("\n");
        }
        return tableString.toString();
    }
}
