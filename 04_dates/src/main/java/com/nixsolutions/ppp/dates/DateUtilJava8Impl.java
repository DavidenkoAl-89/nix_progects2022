package com.nixsolutions.ppp.dates;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.stream.IntStream;


public class DateUtilJava8Impl implements DateUtilJava8 {
    @Override
    public String between(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        int years = period.getYears();
        int month = period.getMonths();
        int days = period.getDays();
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
    public LocalDate[] mondays(Instant instant) {
        LocalDate start = LocalDateTime.ofInstant(instant, ZoneOffset.UTC)
                .toLocalDate().withDayOfMonth(1);

        return IntStream.range(0, start.lengthOfMonth())
                .mapToObj(i -> start.plusDays(i))
                .filter(d -> d.getDayOfWeek() == DayOfWeek.MONDAY)
                .toArray(LocalDate[]::new);
    }
    @Override
    public boolean isFridays13(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfMonth = date.getDayOfMonth();
        return dayOfWeek == DayOfWeek.FRIDAY && dayOfMonth == 13;
    }
    @Override
    public String formatFullJava8(ZonedDateTime date, String language) {
        Locale locale = Locale.forLanguageTag(language);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(locale);
        return date.format(dateTimeFormatter);
    }
}
