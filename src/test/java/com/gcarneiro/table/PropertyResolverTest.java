package com.gcarneiro.table;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Date;

import static com.gcarneiro.table.PropertyResolver.extractProperty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author gabriel.carneiro
 * @since 25/01/16.
 */
public class PropertyResolverTest {

    @Test
    public void testExtractProperty() throws Exception {
        PropertyTestClass obj = new PropertyTestClass();
        obj.string = "TEST";
        obj.bool = false;
        Date date = new Date();
        obj.date = date;
        obj.number = 12345;

        assertThat(extractProperty("string", obj, String.class), is("TEST"));
        assertThat(extractProperty("bool", obj, Boolean.class), is(false));
        assertThat(extractProperty("date", obj, Date.class), is(date));
        assertThat(extractProperty("number", obj, Number.class), Is.<Number>is(12345));
    }

    private class PropertyTestClass {
        String string;
        Date date;
        int number;
        boolean bool;

        public String getString() {
            return string;
        }

        public Date getDate() {
            return date;
        }

        public int getNumber() {
            return number;
        }

        public boolean isBool() {
            return bool;
        }
    }
}