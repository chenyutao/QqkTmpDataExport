package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public final static DateTimeFormatter dfSecondLevel = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String parseByTimestamp(long timestamp) {
        return dfSecondLevel.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
    }

    public static String parseDateToStr(Date date, String patter) {
        SimpleDateFormat sdf = new SimpleDateFormat(patter);
        return sdf.format(date);
    }

    public static String parseDateToStr(Date date) {
        return sdf.format(date);
    }

    public static Date parseByStr(String str) {
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseByStr(String str, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取指定日期之后某天的日期（正数为后，负数为前）
     */
    public static Date getLaterDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}
