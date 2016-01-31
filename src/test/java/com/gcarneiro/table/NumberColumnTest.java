package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class NumberColumnTest {

    @Test
    public void testResolveValue() throws Exception {
        NumberColumn column = new NumberColumn("ColumnName", Alignment.LEFT, 10);

        //Integers
        assertThat(column.resolveValue(5), is("5"));
        assertThat(column.resolveValue(-1), is("-1"));
        assertThat(column.resolveValue(0), is("0"));
        assertThat(column.resolveValue(1231231), is("1,231,231"));

        //Doubles
        assertThat(column.resolveValue(0.0), is("0"));
        assertThat(column.resolveValue(123.321), is("123.321"));
        assertThat(column.resolveValue(0.0000000001), is("0.0000000001"));
        assertThat(column.resolveValue(4565648954D), is("4,565,648,954"));

        //Longs
        assertThat(column.resolveValue(0L), is("0"));
        assertThat(column.resolveValue(12345341312L), is("12,345,341,312"));
        assertThat(column.resolveValue(1001285L), is("1,001,285"));
        assertThat(column.resolveValue(-8798785645778L), is("-8,798,785,645,778"));

        //BigIntegers
        assertThat(column.resolveValue(new BigInteger("1000")), is("1,000"));
        assertThat(column.resolveValue(new BigInteger("7896541231")), is("7,896,541,231"));
        assertThat(column.resolveValue(new BigInteger("100000000000000000")), is("100,000,000,000,000,000"));
        assertThat(column.resolveValue(new BigInteger("-78979877")), is("-78,979,877"));

        //BigDecimals
        assertThat(column.resolveValue(new BigDecimal("0.0")), is("0"));
        assertThat(column.resolveValue(new BigDecimal("-0.001")), is("-0.001"));
        assertThat(column.resolveValue(new BigDecimal("0.186153858111")), is("0.1861538581"));
        assertThat(column.resolveValue(new BigDecimal("100000000000000000")), is("100,000,000,000,000,000"));
    }

    @Test
    public void testGetType() throws Exception {
        NumberColumn column = new NumberColumn("ColumnName", Alignment.LEFT, 2);
        assertEquals(column.getType(), Number.class);
    }

    @Test
    public void testGetColumnName() throws Exception {
        NumberColumn column = new NumberColumn("ColumnName", Alignment.LEFT, 2);
        assertThat(column.getColumnName(), is("ColumnName"));
    }
}