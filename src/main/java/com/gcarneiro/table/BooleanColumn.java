package com.gcarneiro.table;

import com.gcarneiro.table.api.PropertyColumn;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class BooleanColumn extends PropertyColumn<Boolean> {

    //Todo: enable configuration of yes/no values
    private static final String YES = "Yes";

    private static final String NO = "No";

    protected BooleanColumn(String columnName) {
        super(columnName);
    }

    @Override
    public String resolveValue(Boolean data) {
        return data ? YES : NO;
    }

    @Override
    public Class<Boolean> getType() {
        return Boolean.class;
    }
}
