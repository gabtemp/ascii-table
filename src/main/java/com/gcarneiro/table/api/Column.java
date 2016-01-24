package com.gcarneiro.table.api;

import java.io.Serializable;

/**
 * Represents a column, store its name and knows how to render row values.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public interface Column<T extends Serializable> {

    String getColumnName();

    String getRowProperty();

    void setRowProperty(String rowProperty);

    String resolveValue(T data);

    Class<T> getType();
}
