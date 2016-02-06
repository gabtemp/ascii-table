package com.gcarneiro.table.api;

import com.gcarneiro.table.PropertyResolver;

import java.io.Serializable;

/**
 * An abstract column that stores the property to extract the values from its rows
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public abstract class PropertyColumn<T extends Serializable> implements Column<T> {

    private final String columnName;

    private Alignment columnAlignment = Alignment.LEFT;

    private String rowProperty;

    protected PropertyColumn(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String getRowValue(Object row) {
        T value = PropertyResolver.extractProperty(getRowProperty(), row, getType());
        return this.resolveValue(value);
    }

    protected abstract String resolveValue(T data);

    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public Alignment getColumnAlignment() {
        return columnAlignment;
    }

    @Override
    public void setColumnAlignment(Alignment columnAlignment) {
        this.columnAlignment = columnAlignment;
    }

    public String getRowProperty() {
        return this.rowProperty;
    }

    public void setRowProperty(String rowProperty) {
        this.rowProperty = rowProperty;
    }
}
