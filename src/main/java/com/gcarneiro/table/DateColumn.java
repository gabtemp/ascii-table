package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
import com.gcarneiro.table.api.PropertyColumn;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A column that renders {@link Date} rows with configurable locale and format.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class DateColumn extends PropertyColumn<Date> {

    //Todo: Enable configuration of the format and locale
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

    protected DateColumn(String columnName, Alignment columnAlignment) {
        super(columnName, columnAlignment);
    }

    public String resolveValue(Date data) {
        return format.format(data);
    }

    public Class<Date> getType() {
        return Date.class;
    }
}
