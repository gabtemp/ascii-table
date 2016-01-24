package com.gcarneiro.table;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class StringColumnTest {

    @Test
    public void testResolveValue() throws Exception {
        StringColumn column = new StringColumn("ColumnName");

        assertThat(column.resolveValue(""), is(""));
        assertThat(column.resolveValue("data"), is("data"));
        assertThat(column.resolveValue("  data "), is("  data "));
    }

    @Test
    public void testGetType() throws Exception {
        StringColumn column = new StringColumn("ColumnName");
        assertEquals(column.getType(), String.class);
    }

    @Test
    public void testGetColumnName() throws Exception {
        StringColumn column = new StringColumn("ColumnName");
        assertThat(column.getColumnName(), is("DateColumn"));
    }
}