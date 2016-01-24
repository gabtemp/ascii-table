package com.gcarneiro.table.creator;

import com.gcarneiro.table.DateColumn;
import com.gcarneiro.table.PropertyTable;
import com.gcarneiro.table.StringColumn;
import com.gcarneiro.table.api.Column;
import com.gcarneiro.table.api.Table;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class TableCreator {

    private List<Column> columns = new LinkedList<>();

    private List<?> rows;

    /**
     * Creates a new {@link String} column with the provided name. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @return the new column for further configuration.
     */
    public Column<String> addStringColumn(String columnName, String property) {
        StringColumn column = new StringColumn(columnName);
        column.setRowProperty(property);
        columns.add(column);
        return column;
    }

    /**
     * Creates a new {@link Date} column with the provided name. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @return the new column for further configuration.
     */
    public Column<Date> addDateColumn(String columnName, String property) {
        DateColumn column = new DateColumn(columnName);
        column.setRowProperty(property);
        columns.add(column);
        return column;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public String createAsciiTable() {
        Table table = new PropertyTable();
        table.setColumns(columns);
        table.setRows(rows);
        return table.renderTable();
    }
}
