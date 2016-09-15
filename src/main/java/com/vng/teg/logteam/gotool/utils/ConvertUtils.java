package com.vng.teg.logteam.gotool.utils;

public class ConvertUtils {

    public static int toInt(String value, int ifnull) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return ifnull;
        }
    }

    public static long toLong(String value, long ifnull) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return ifnull;
        }
    }

    public static double toDouble(String value, double ifnull) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return ifnull;
        }
    }

    public static float toFloat(String value, float ifnull) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return ifnull;
        }
    }

    public static String toString(Object value, String ifnull) {
        if(value == null || !(value instanceof String)) {
            return ifnull;
        }

        return value.toString();
    }
}
