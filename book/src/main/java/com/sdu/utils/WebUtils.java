package com.sdu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamtoBean(Map value,T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
