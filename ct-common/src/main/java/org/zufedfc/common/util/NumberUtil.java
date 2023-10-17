package org.zufedfc.common.util;

import java.text.DecimalFormat;
import java.util.Calendar;

public class NumberUtil {

    public static String formatNumber(long number, int length) {
        String zeros = "";
        for (int i = 0; i < length; i++) {
            zeros += "0";
        }
        DecimalFormat df = new DecimalFormat(zeros);
        return df.format(number);
    }



}
