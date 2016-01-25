package com.gcarneiro.table;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author gabriel.carneiro
 * @since 25/01/16.
 */
public class PropertyResolver {


    public static <T extends Serializable> T extractProperty(String rowProperty, Object row, Class<T> type) {
        try {
            Method method = findGetMethod(rowProperty, row);
            Object value = method.invoke(row);
            return type.cast(value);
        } catch (Exception e) {
            //TODO: resolve exceptions
            throw new RuntimeException();
        }
    }

    private static Method findGetMethod(String rowProperty, Object row) throws NoSuchMethodException {
        final String GET_METHOD = "get";
        final String IS_METHOD = "is";

        String methodSuffix = rowProperty.substring(0, 1).toUpperCase() + rowProperty.substring(1);
        String getMethod = GET_METHOD + methodSuffix;
        Method method;
        try {
            method = row.getClass().getMethod(getMethod);
        } catch (NoSuchMethodException e) {
            String isMethod = IS_METHOD + methodSuffix;
            method = row.getClass().getMethod(isMethod);
        }
        return method;
    }
}
