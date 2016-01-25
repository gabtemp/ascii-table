package com.gcarneiro.table.api;

/**
 * @author gabriel.carneiro
 * @since 25/01/16.
 */
public enum Alignment {
    LEFT {
        @Override
        public String padString(String string, int length) {
            return String.format("%1$-" + length + "s", string);
        }
    },

    CENTER {
        @Override
        public String padString(String string, int length) {
            return null;
        }
    },

    RIGHT {
        @Override
        public String padString(String string, int length) {
            return String.format("%1$" + length + "s", string);
        }
    };

    public abstract String padString(String string, int length);
}
