package com.tingo.core.utils;

import java.lang.reflect.Type;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;

/**
 * Created by tengfei on 2016/7/25.
 */
public class GSONHelper {
    public static <T> T convert(String str,Class<T> clazz) {
        if(null == clazz) {
            return null;
        }
        if(clazz == String.class) {
            return (T)str;
        }
        return new Gson().fromJson(str,clazz);
    }

    public static <T> T convert(String str, Type type) {
        return null;
    }

    public static String toJson(Object obj) {
        if(null == obj) {
            return "";
        }
        return new Gson().toJson(obj);
    }
}
