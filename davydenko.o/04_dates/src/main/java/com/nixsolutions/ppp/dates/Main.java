package com.nixsolutions.ppp.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Java7");
        DateUtilJava7 dUJava7 = new DateUtilJava7Impl();
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println(dUJava7.between(dateFormat.parse("2020.03.10"), dateFormat.parse("2021.04.11")));
        System.out.println("------------");
        System.out.println(Arrays.toString(dUJava7.daysInMonth(2018)));
        System.out.println("-------------");
        System.out.println(Arrays.toString(dUJava7.mondays(0, 2018)));
        System.out.println("--------------");
        System.out.println(dUJava7.isFridays13(dateFormat.parse("2021.08.13")));
        System.out.println("---------------");
        System.out.println(dUJava7.formatFull(dateFormat.parse("2021.10.24"), "ru"));
        System.out.println("Java8");
        DateUtilJava8 dUtJava8 = new DateUtilJava8Impl();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date1 = LocalDate.parse("10.05.2020", formatter);
        LocalDate date2 = LocalDate.parse("11.04.2021", formatter);
        System.out.println(dUtJava8.between(date1, date2));
        System.out.println(Arrays.toString(dUtJava8.mondays(Instant.now())));
        System.out.println(dUtJava8.isFridays13(LocalDate.parse("13.08.2021", formatter)));
        System.out.println(dUtJava8.formatFullJava8(ZonedDateTime.now(), "ru"));
    }
}
