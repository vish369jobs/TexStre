package com.texstre.celebclothing.util;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class NullAwareBeanUtilsBean extends BeanUtilsBean {

    @Override
    public void copyProperty(Object bean, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if (value == null) {
            return; // Ignore null values from copying
        }
        super.copyProperty(bean, name, value);
    }
}