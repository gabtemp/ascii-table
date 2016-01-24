package com.gcarneiro.table;

import com.gcarneiro.table.api.Column;
import com.gcarneiro.table.api.Table;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * A table that resolver its cell values from an object's properties (using reflection).
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class PropertyTable implements Table {

    List<Column> columns;

    List<?> rows;

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
                Serializable value = this.getRowValue(column, row);
                tableString.append(column.resolveValue(value));
                tableString.append(" | ");
            }
            tableString.append("\n");
        }
        return tableString.toString();
    }

    private Serializable getRowValue(Column column, Object row) {
        try {
            Method method = findGetMethod(column.getRowProperty(), row);
            Object value = method.invoke(row);
            return (Serializable) column.getType().cast(value);
        } catch (Exception e) {
            //TODO: resolve exceptions
            throw new RuntimeException();
        }
    }

    private Method findGetMethod(String rowProperty, Object row) throws NoSuchMethodException {
        final String GET_METHOD = "get";
        final String IS_METHOD = "is";

        String methodSuffix = rowProperty.substring(0, 1).toUpperCase() + rowProperty.substring(1);
        String getMethod = GET_METHOD + methodSuffix;
        Method method;
        try {
            method = row.getClass().getMethod(getMethod);
        } catch (NoSuchMethodException e) {
            String isMethod = IS_METHOD + methodSuffix;
            method = row.getClass().getMethod(isMethod);
        }
        return method;
    }
}
