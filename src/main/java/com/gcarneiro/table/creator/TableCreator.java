package com.gcarneiro.table.creator;

import com.gcarneiro.table.DateColumn;
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
public abstract class TableCreator {

    private List<Column> columns = new LinkedList<Column>();

    private List<Object> rows;

    public Column<String> addStringColumn(String columnName) {
        StringColumn column = new StringColumn(columnName);
        columns.add(column);
        return column;
    }

    public Column<Date> addDateColumn(String columnName) {
        DateColumn column = new DateColumn(columnName);
        columns.add(column);
        return column;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public String createAsciiTable() {
        Table table = this.getTable();
        table.setColumns(columns);
        table.setRows(rows);
        return table.renderTable();
    }

    protected abstract Table getTable();
}
