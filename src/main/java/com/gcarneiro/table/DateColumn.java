package com.gcarneiro.table;

import com.gcarneiro.table.api.Column;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class DateColumn implements Column<Date> {

    //Todo: Enable configuration of the format
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");

    public String resolveValue(Date data) {
        return format.format(data);
    }

    public Class<Date> getType() {
        return Date.class;
    }
}
