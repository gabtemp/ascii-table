package com.gcarneiro.table;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class BooleanColumnTest {

    @Test
    public void testResolveValue() throws Exception {
        BooleanColumn column = new BooleanColumn("ColumnName");
        assertThat(column.resolveValue(true), is("Yes"));
        assertThat(column.resolveValue(false), is("No"));
        assertThat(column.resolveValue(Boolean.TRUE), is("Yes"));
        assertThat(column.resolveValue(Boolean.FALSE), is("No"));
    }

    @Test
    public void testGetType() throws Exception {
        BooleanColumn column = new BooleanColumn("ColumnName");
        assertEquals(column.getType(), Boolean.class);
    }

    @Test
    public void testGetColumnName() throws Exception {
        BooleanColumn column = new BooleanColumn("ColumnName");
        assertThat(column.getColumnName(), is("ColumnName"));
    }
}