package com.gcarneiro.table.api;

import java.io.Serializable;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public abstract class AbstractColumn<T extends Serializable> implements Column<T> {

    private String columnName;

    private String rowProperty;

    protected AbstractColumn(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public String getRowProperty() {
        return this.rowProperty;
    }

    @Override
    public void setRowProperty(String rowProperty) {
        this.rowProperty = rowProperty;
    }
}
