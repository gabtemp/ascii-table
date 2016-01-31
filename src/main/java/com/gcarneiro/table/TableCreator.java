package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
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
     * @param alignment  this column's alignment
     * @return the new column for further configuration.
     */
    public Column<String> addStringColumn(String columnName, String property, Alignment alignment) {
        StringColumn column = new StringColumn(columnName, alignment);
        column.setRowProperty(property);
        columns.add(column);
        return column;
    }

    /**
     * Creates a new {@link String} column with the provided name with <b>left alignment</b>. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @return the new column for further configuration.
     */
    public Column<String> addStringColumn(String columnName, String property) {
        return this.addStringColumn(columnName, property, Alignment.LEFT);
    }

    /**
     * Creates a new {@link Date} column with the provided name. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @param alignment  this column's alignment
     * @return the new column for further configuration.
     */
    public Column<Date> addDateColumn(String columnName, String property, Alignment alignment) {
        DateColumn column = new DateColumn(columnName, alignment);
        column.setRowProperty(property);
        columns.add(column);
        return column;
    }

    /**
     * Creates a new {@link Date} column with the provided name with <b>left alignment</b>. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @return the new column for further configuration.
     */
    public Column<Date> addDateColumn(String columnName, String property) {
        return this.addDateColumn(columnName, property, Alignment.LEFT);
    }

    /**
     * Creates a new {@link Boolean} column with the provided name. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @param alignment  this column's alignment
     * @return the new column for further configuration.
     */
    public Column<Boolean> addBooleanColumn(String columnName, String property, Alignment alignment) {
        BooleanColumn column = new BooleanColumn(columnName, alignment);
        column.setRowProperty(property);
        columns.add(column);
        return column;
    }

    /**
     * Creates a new {@link Boolean} column with the provided name with <b>left alignment</b>. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @return the new column for further configuration.
     */
    public Column<Boolean> addBooleanColumn(String columnName, String property) {
        return this.addBooleanColumn(columnName, property, Alignment.LEFT);
    }

    /**
     * Creates a new {@link Number} column with the provided name. The value of all rows in this column will be extracted from
     * the given property.
     *
     * @param columnName    this column's name
     * @param property      the row's property that will be extracted
     * @param decimalPlaces how many decimals places will be rendered
     * @param alignment     this column's alignment
     * @return the new column for further configuration.
     */
    public Column<Number> addNumberColumn(String columnName, String property, Alignment alignment, int decimalPlaces) {
        NumberColumn column = new NumberColumn(columnName, alignment, decimalPlaces);
        column.setRowProperty(property);
        columns.add(column);
        return column;
    }

    /**
     * Creates a new {@link Number} column with the provided name with 2 decimal places. The value of all rows in this
     * column will be extracted from the given property.
     *
     * @param columnName this column's name
     * @param property   the row's property that will be extracted
     * @return the new column for further configuration.
     */
    public Column<Number> addNumberColumn(String columnName, String property) {
        return this.addNumberColumn(columnName, property, Alignment.LEFT, 2);
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public String createAsciiTable() {
        Table table = new TableImpl();
        table.setColumns(columns);
        table.setRows(rows);
        return table.renderTable();
    }
}
