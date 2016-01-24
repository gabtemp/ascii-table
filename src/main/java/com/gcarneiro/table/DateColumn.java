package com.gcarneiro.table;

import com.gcarneiro.table.api.Column;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A column that renders {@link Date} rows with configurable locale and format.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class DateColumn implements Column<Date> {

    private final String columnName;
    //Todo: Enable configuration of the format and locale
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

    public DateColumn(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String resolveValue(Date data) {
        return format.format(data);
    }

    public Class<Date> getType() {
        return Date.class;
    }
}
