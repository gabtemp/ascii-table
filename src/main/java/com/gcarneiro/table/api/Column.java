package com.gcarneiro.table.api;

import java.io.Serializable;

/**
 * @author gabriel.carneiro
 * @since 24/01/16.
 */
public interface Column<T extends Serializable> {

    String resolveValue(T data);

    Class<? extends T> getType();
}
