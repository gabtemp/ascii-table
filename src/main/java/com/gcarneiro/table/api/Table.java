package com.gcarneiro.table.api;

import java.util.List;

/**
 * A table that stores all its columns and rows and renders those columns and rows in String.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public interface Table {

    void setColumns(List<Column> columns);

    void setRows(List<?> rows);

    String renderTable();
}
