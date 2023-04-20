package com.nixsolutions.ppp.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class DateUtilJava7Impl implements DateUtilJava7 {
    @Override
    public String between(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.setTime(date2);
        long diff = date2.getTime() - date1.getTime();
        long days = diff / (24L * 60L * 60L * 1000L) % 30L;
        long month = diff / (30L * 24L * 60L * 60L * 1000L) % 12L;
        long years = diff / (12L * 30L * 24L * 60L * 60L * 1000L);
        if (years != 0 && month != 0 && days != 0) {
            return years + " year " + month + " month " + days + " days ";
        }
        if (years == 0 && month == 0) {
            return days + " days ";
        }
        if (month == 0 && days == 0) {
            return years + " year ";
        }
        if (years == 0 && days == 0) {
            return month + " month ";
        }
        if (years == 0) {
            return month + " month " + days + " days ";
        }
        if (month == 0) {
            return years + " year " + days + " days ";
        }
        return years + " year " + month + " month ";
    }
    @Override
    public int[] daysInMonth(int year) {
        int[] monthArray = {Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH, Calendar.APRIL,
                Calendar.MAY, Calendar.JUNE, Calendar.JULY, Calendar.AUGUST, Calendar.SEPTEMBER,
                Calendar.OCTOBER, Calendar.NOVEMBER, Calendar.DECEMBER};

        int[] daysResult = new int[12];
        int daysInMonth;
        for (int i = 0; i < monthArray.length; i++) {
            Calendar countOfDays = new GregorianCalendar(year, monthArray[i], 1);
            daysInMonth = countOfDays.getActualMaximum(Calendar.DAY_OF_MONTH);
            daysResult[i] = daysInMonth;
        }
        return daysResult;
    }
    @Override
    public Date[] mondays(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        List<Date> mondays = new ArrayList<>();
        do {
            mondays.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 7);
        }
        while (calendar.get(Calendar.DAY_OF_MONTH) < calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                && calendar.get(Calendar.MONTH) == month);
        return mondays.toArray(new Date[0]);
    }
    @Override
    public boolean isFridays13(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == 6 && calendar.get(Calendar.DAY_OF_MONTH) == 13;
    }
    @Override
    public String formatFull(Date date, String language) {
        Locale locale = Locale.forLanguageTag(language);
        return SimpleDateFormat.getDateInstance(DateFormat.FULL, locale)
                .format(date);
    }
}
