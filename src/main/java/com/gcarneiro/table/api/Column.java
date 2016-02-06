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

    Alignment getColumnAlignment();

    void setColumnAlignment(Alignment alignment);

    <E> String getRowValue(E row);

    Class<T> getType();
}
