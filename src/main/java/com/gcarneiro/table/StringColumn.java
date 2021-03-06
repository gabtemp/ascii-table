package com.gcarneiro.table;

import com.gcarneiro.table.api.PropertyColumn;

/**
 * A column that renders {@link String} rows.
 *
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class StringColumn extends PropertyColumn<String> {

    protected StringColumn(String columnName) {
        super(columnName);
    }

    public String resolveValue(String data) {
        return data;
    }

    public Class<String> getType() {
        return String.class;
    }
}
