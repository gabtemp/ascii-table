package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.JANUARY;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class DateColumnTest {

    @Test
    public void testResolveValue() throws Exception {
        DateColumn column = new DateColumn("DateColumn", Alignment.LEFT);
        Calendar calendar = Calendar.getInstance();

        calendar.set(2000, JANUARY, 22);
        assertThat(column.resolveValue(calendar.getTime()), is("22/01/2000"));

        calendar.set(1966, Calendar.DECEMBER, 25);
        assertThat(column.resolveValue(calendar.getTime()), is("25/12/1966"));

        calendar.set(2016, Calendar.FEBRUARY, 29);
        assertThat(column.resolveValue(calendar.getTime()), is("29/02/2016"));
    }

    @Test
    public void testGetType() throws Exception {
        DateColumn column = new DateColumn("ColumnName", Alignment.LEFT);
        assertEquals(column.getType(), Date.class);
    }

    @Test
    public void testGetColumnName() throws Exception {
        DateColumn column = new DateColumn("DateColumn", Alignment.LEFT);
        assertThat(column.getColumnName(), is("DateColumn"));
    }
}