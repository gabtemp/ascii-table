package com.gcarneiro.table;

import com.gcarneiro.table.api.Alignment;
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
public class TableImplTest {

    @Test
    public void testStringTable() {
        TableImpl<TestRow> table = new TableImpl<>();

        Column column = new StringColumn("COLUMN", Alignment.LEFT);
        column.setRowProperty("string");
        TestRow row = new TestRow();
        row.string = "ROW";

        table.setColumns(Collections.singletonList(column));
        table.setRows(Collections.singletonList(row));

        String tableString = table.renderTable();
        assertThat(tableString, is("+--------+\n| COLUMN |\n+--------+\n| ROW    |\n+--------+\n"));
    }

    @Test
    public void testDateTable() {
        TableImpl<TestRow> table = new TableImpl<>();

        Column column = new DateColumn("COLUMN", Alignment.LEFT);
        column.setRowProperty("date");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, JANUARY, 24);
        TestRow row = new TestRow();
        row.date = calendar.getTime();

        table.setColumns(Collections.singletonList(column));
        table.setRows(Collections.singletonList(row));

        String tableString = table.renderTable();
        assertThat(tableString, is("+------------+\n| COLUMN     |\n+------------+\n| 24/01/2016 |\n+------------+\n"));
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