package com.tanveershafeeprottoy.basedatabindingcomponents.converters;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BasicConverters {

    public static String intToString(int integer) {
        try {
            return String.valueOf(integer);
        }
        catch(Exception e) {
            return "";
        }
    }

    public static String doubleToString(double doubleVal) {
        try {
            return String.valueOf(doubleVal);
        }
        catch(Exception e) {
            return "";
        }
    }
}
