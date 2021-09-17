package com.yuanian.encry.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * @author zhahsh
 * @date 2021/9/17
 */
public class DateUtils {

    /**
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_SSS = "yyyy-MM-dd HH:mm:ss:SSS";


    /**
     * 把日期字符串格式化成日期类型
     * @param dateStr 日期字符串
     * @param format 格式
     * @return 日期
     */
    public static Date convert2Date(String dateStr, String format) {
        SimpleDateFormat simple = new SimpleDateFormat(format);
        try {
            simple.setLenient(false);
            return simple.parse(dateStr);
        } catch (Exception e) {
            return  null;
        }
    }


    /**
     * 把日期类型格式化成字符串
     * @param date 日期
     * @param format 格式
     * @return 字符串
     */
    public static String convert2String(Date date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            return formater.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 转sql的time格式
     * @param date 日期
     * @return 时间戳
     */
    public static java.sql.Timestamp convertSqlTime(Date date){
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        return timestamp;
    }

    /**
     * 转sql的日期格式
     * @param date 日期
     * @return sql日期格式
     */
    public static java.sql.Date convertSqlDate(Date date){
        java.sql.Date dateTamp = new java.sql.Date(date.getTime());
        return dateTamp;
    }


    /**
     * 获取当前日期
     * @param format 格式
     * @return 当前日期字符串
     */
    public static String getCurrentDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }
    /**
     * 获取当前日期加豪秒
     * @return 当前日期至毫秒
     */
    public static String getCurrentMilliseconds() {
        return new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_SSS).format(new Date());
    }

    /**
     * 获取当前日期
     * @return 当前日期至秒
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS).format(new Date());
    }
    /**
     * 获取当前日期加秒
     * @param amount
     * @return
     */
    public static String getAddSecondsDate(int amount) {
        return new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS).format(addMilliseconds(new Date(),amount));
    }
    /**
     * 获取当前日期加豪秒
     * @param amount
     * @return
     */
    public static String getAddMillisecondsDate(int amount) {
        return new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS_SSS).format(addMilliseconds(new Date(),amount));
    }

    /**
     * 获取当前日期
     * @param format
     * @return
     */
    public static Date getCurrentDateTime() {
        return  new Date();
    }

    /**
     * 获取时间戳
     * @return
     */
    public static long getTimestamp()
    {
        return System.currentTimeMillis();
    }

    /**
     * 获取月份的天数
     * @param year
     * @param month
     * @return
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期的年
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取日期的月
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的日
     * @param date 日期
     * @return 日
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取日期的时
     * @param date 日期
     * @return 小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR);
    }

    /**
     * 获取日期的分种
     * @param date 日期
     * @return 分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取日期的秒
     * @param date 日期
     * @return 秒
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取星期几
     * @param date 日期
     * @return 分钟
     */
    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek-1;
    }

    /**
     * 获取哪一年共有多少周
     * @param year 年
     * @return 周数
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekNumOfYear(c.getTime());
    }

    /**
     * 取得某天是一年中的多少周
     * @param date 日期
     * @return 第几周
     */
    public static int getWeekNumOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 取得某天所在周的第一天
     * @param date 日期
     * @return 日期
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c.getTime();
    }

    /**
     * 取得某天所在周的最后一天
     * @param date 日期
     * @return 日期
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    /**
     * 取得某年某周的第一天 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周,2009-01-05为2009年第一周的第一天
     * @param year 年
     * @param week 周
     * @return 日期
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar calFirst = Calendar.getInstance();
        calFirst.set(year, 0, 7);
        Date firstDate = getFirstDayOfWeek(calFirst.getTime());

        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        firstDate = getFirstDayOfWeek(cal.getTime());

        return firstDate;
    }

    /**
     * 取得某年某周的最后一天 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周, 2009-01-04为
     * 2008年最后一周的最后一天
     * @param year 年
     * @param week 周
     * @return 日期
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar calLast = Calendar.getInstance();
        calLast.set(year, 0, 7);
        Date firstDate = getLastDayOfWeek(calLast.getTime());

        Calendar firstDateCal = Calendar.getInstance();
        firstDateCal.setTime(firstDate);

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (week - 1) * 7);
        Date lastDate = getLastDayOfWeek(cal.getTime());

        return lastDate;
    }


    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

    /**
     * 增加年
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addYears(Date date, int amount) {
        return add(date, 1, amount);
    }

    /**
     * 增加月
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, 2, amount);
    }

    /**
     * 增加周
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, 3, amount);
    }

    /**
     * 增加天
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addDays(Date date, int amount) {
        return add(date, 5, amount);
    }

    /**
     * 增加时
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addHours(Date date, int amount) {
        return add(date, 11, amount);
    }

    /**
     * 增加分
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, 12, amount);
    }

    /**
     * 增加秒
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, 13, amount);
    }

    /**
     * 增加毫秒
     * @param date 日期
     * @param amount 数量
     * @return 日期
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, 14, amount);
    }



    /**
     * time差
     * @param before 开始日期
     * @param after 结束日期
     * @return 时间差
     */
    public static long diffTimes(Date before, Date after){
        return after.getTime() - before.getTime();
    }

    /**
     * 秒差
     * @param before 开始日期
     * @param after 结束日期
     * @return 秒差
     */
    public static long diffSecond(Date before, Date after){
        return (after.getTime() - before.getTime())/1000;
    }

    /**
     * 分种差
     * @param before 开始日期
     * @param after 结束日期
     * @return 分钟差
     */
    public static int diffMinute(Date before, Date after){
        return (int)(after.getTime() - before.getTime())/1000/60;
    }

    /**
     * 时差
     * @param before 开始日期
     * @param after 结束日期
     * @return 时钟差
     */
    public static int diffHour(Date before, Date after){
        return (int)(after.getTime() - before.getTime())/1000/60/60;
    }

    /**
     * 天数差
     * @param before 开始日期
     * @param after 结束日期
     * @return 天数差
     */
    public static int diffDay(Date before, Date after) {
        return Integer.parseInt(String.valueOf(((after.getTime() - before.getTime()) / 86400000)));
    }

    /**
     * 月差
     * @param before 开始
     * @param after 结束
     * @return 月差
     */
    public static int diffMonth(Date before, Date after){
        int monthAll=0;
        int yearsX = diffYear(before,after);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(before);
        c2.setTime(after);
        int monthsX = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        monthAll=yearsX*12+monthsX;
        int daysX =c2.get(Calendar.DATE) - c1.get(Calendar.DATE);
        if(daysX>0){
            monthAll=monthAll+1;
        }
        return monthAll;
    }

    /**
     * 年差
     * @param before 开始
     * @param after 结束
     * @return 年差
     */
    public static int diffYear(Date before, Date after) {
        return getYear(after) - getYear(before);
    }

    /**
     * 设置23:59:59
     * @param date 日期
     * @return 日期
     */
    public static Date setEndDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 设置00:00:00
     * @param date 日期
     * @return 日期
     */
    public static Date setStartDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * @param timeMillis 时间戳
     * @return 日期字符串
     */
    public static String formatDateTime(long timeMillis){
        long day = timeMillis/(24*60*60*1000);
        long hour = (timeMillis/(60*60*1000)-day*24);
        long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
        long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
        long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
        return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }

    /**
     * 根据传入的毫秒数（可以是正、负数），和当前时间的毫秒数求和，得出相差的时间。
     *
     * @param millis 毫秒
     * @return 和当前时间相差的时间对象
     */
    public static Date getDiffDateOfCurrent(long millis) {
        long curren = System.currentTimeMillis();
        curren += millis;
        return new Date(curren);
    }
}
