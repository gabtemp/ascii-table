package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
import com.gcarneiro.table.api.PropertyColumn;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class NumberColumn extends PropertyColumn<Number> {

    private final int decimalPlaces;

    protected NumberColumn(String columnName, Alignment columnAlignment, int decimalPlaces) {
        super(columnName, columnAlignment);
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public String resolveValue(Number data) {
        //TODO: Enable configuration of number format/locale
        NumberFormat instance = NumberFormat.getInstance(Locale.ENGLISH);
        instance.setMaximumFractionDigits(decimalPlaces);
        return instance.format(data);
    }

    @Override
    public Class<Number> getType() {
        return Number.class;
    }
}
