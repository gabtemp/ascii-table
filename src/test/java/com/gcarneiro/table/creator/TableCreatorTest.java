package com.gcarneiro.table.creator;

import com.gcarneiro.table.api.Column;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public class TableCreatorTest {

    /**
     * Counts the number of lines ignoring the EOF newline
     */
    private static int countLines(String s) {
        return (s).split("\r?\n").length;
    }

    @Test
    public void testAddStringColumn() throws Exception {
        TableCreator tableCreator = new TableCreator();
        Column<String> column = tableCreator.addStringColumn("StringColumn", "string");

        assertThat(column.getColumnName(), is("StringColumn"));
        assertThat(column.getRowProperty(), is("string"));
        assertThat(column.getType(), Is.<Class<String>>is(String.class));
    }

    @Test
    public void testAddDateColumn() throws Exception {
        TableCreator tableCreator = new TableCreator();
        Column<Date> column = tableCreator.addDateColumn("DateColumn", "date");

        assertThat(column.getColumnName(), is("DateColumn"));
        assertThat(column.getRowProperty(), is("date"));
        assertThat(column.getType(), Is.<Class<Date>>is(Date.class));
    }

    @Test
    public void testCreateAsciiTable() throws Exception {
        TableCreator tableCreator = new TableCreator();
        tableCreator.addStringColumn("DateColumn", "string");
        tableCreator.addDateColumn("StringColumn", "date");
        tableCreator.setRows(getRows());
        String tableString = tableCreator.createAsciiTable();
        assertThat(countLines(tableString), is(3));
    }

    private List<TestRow> getRows() {
        List<TestRow> rows = new ArrayList<>();
        rows.add(new TestRow("Row1", new Date()));
        rows.add(new TestRow("Row2", new Date()));
        return rows;
    }

    public class TestRow {
        String string;
        Date date;

        public TestRow(String string, Date date) {
            this.string = string;
            this.date = date;
        }

        public String getString() {
            return string;
        }

        public Date getDate() {
            return date;
        }
    }
}