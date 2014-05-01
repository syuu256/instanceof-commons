/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String H_DATE_FROMAT = "yyyyMMdd";

    public static String toNextDayYMD() {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

    public static Date parseSalesDate(final String ymd) {

        if (ymd == null || ymd.isEmpty()) {
            return null;
        }

        final DateFormat dateFormat = new SimpleDateFormat(H_DATE_FROMAT);
        Date tmp;
        try {
            tmp = dateFormat.parse(ymd);
        } catch (ParseException e) {
            return null;
        }
        return tmp;
    }

    public static String formatDate(final long time) {
        return new SimpleDateFormat(H_DATE_FROMAT).format(new Date(time));
    }

}
