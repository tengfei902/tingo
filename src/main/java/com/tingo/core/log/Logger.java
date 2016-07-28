package com.tingo.core.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by tengfei on 2016/7/28.
 */
public class Logger {
    private static Log getLogger(Class clazz) {
        return  LogFactory.getLog(clazz);
    }

    public static void debug(Class clazz,String msg) {
        getLogger(clazz).debug(msg);
    }

    public static void info(Class clazz,String msg) {
        getLogger(clazz).info(msg);
    }

    public static void warn(Class clazz,String msg) {
        getLogger(clazz).warn(msg);
    }

    public static void error(Class clazz,String msg) {
        getLogger(clazz).error(msg);
    }

    public static void fatal(Class clazz,String msg) {
        getLogger(clazz).fatal(msg);
    }


}
