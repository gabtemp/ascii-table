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
            int spaces = length - string.length();
            if (spaces <= 0) {
                return string;
            } else {
                int right = spaces / 2;
                return LEFT.padString(RIGHT.padString(string, string.length() + right), string.length() + spaces);
            }
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
