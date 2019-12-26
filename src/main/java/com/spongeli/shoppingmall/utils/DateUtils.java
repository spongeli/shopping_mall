package com.spongeli.shoppingmall.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 通过事件拿到时分
     *
     * @param date
     * @return
     */
    public static String getDateHourMINUTE(Date date) {
        if (date == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (!isSameDay(date, new Date())) {
            return new SimpleDateFormat("yyyy/MM/dd").format(date);
        }

        StringBuffer sb = new StringBuffer();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10) {
            sb.append(0).append(hour);
        }else{
            sb.append(hour);
        }
        sb.append(":");
        int minute = calendar.get(Calendar.MINUTE);
        if (minute < 10) {
            sb.append(0).append(minute);
        }else{
            sb.append(minute);
        }
        return sb.toString();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DATE) == calendar2.get(Calendar.DATE)) {
            return true;
        }
        return false;
    }

}
