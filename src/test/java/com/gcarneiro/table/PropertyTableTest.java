package com.gcarneiro.table;

import com.gcarneiro.table.api.Column;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import static java.util.Calendar.JANUARY;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class PropertyTableTest {

    @Test
    public void testStringTable() {
        PropertyTable table = new PropertyTable();

        Column column = new StringColumn("COLUMN");
        column.setRowProperty("string");
        TestRow row = new TestRow();
        row.string = "ROW";

        table.setColumns(Collections.singletonList(column));
        table.setRows(Collections.singletonList(row));

        String tableString = table.renderTable();
        assertThat(tableString, is("| COLUMN | \n| ROW | \n"));
    }

    @Test
    public void testDateTable() {
        PropertyTable table = new PropertyTable();

        Column column = new DateColumn("COLUMN");
        column.setRowProperty("date");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, JANUARY, 24);
        TestRow row = new TestRow();
        row.date = calendar.getTime();

        table.setColumns(Collections.singletonList(column));
        table.setRows(Collections.singletonList(row));

        String tableString = table.renderTable();
        assertThat(tableString, is("| COLUMN | \n| 24/01/2016 | \n"));
    }

    private class TestRow {
        String string;
        Date date;

        public String getString() {
            return string;
        }

        public Date getDate() {
            return date;
        }
    }
}