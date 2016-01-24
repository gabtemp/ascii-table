package com.gcarneiro.table;

import com.gcarneiro.table.api.Column;

/**
 * A column that renders {@link String} rows.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class StringColumn implements Column<String> {

    private final String columnName;
    private String rowProperty;

    public StringColumn(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getRowProperty() {
        return rowProperty;
    }

    public void setRowProperty(String rowProperty) {
        this.rowProperty = rowProperty;
    }

    public String resolveValue(String data) {
        return data;
    }

    public Class<String> getType() {
        return String.class;
    }
}
