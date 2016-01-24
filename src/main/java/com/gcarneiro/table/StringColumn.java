package com.gcarneiro.table;

import com.gcarneiro.table.api.Column;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class StringColumn implements Column<String> {

    public String resolveValue(String data) {
        return data;
    }

    public Class<String> getType() {
        return String.class;
    }
}
