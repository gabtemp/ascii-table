package com.gcarneiro.table.api;

import java.util.List;

/**
 * A table that stores all its columns and rows and renders those columns and rows in String.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public interface Table<T> {

    void setColumns(List<? extends Column> columns);

    void setRows(List<T> rows);

    String renderTable();
}
