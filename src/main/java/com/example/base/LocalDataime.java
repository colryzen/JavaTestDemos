package com.example.base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDataime {

    public static void main(String[] args) {
       test();

    }




    public static void test() {
        //判断两个时间点的前后
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end=now.withDayOfMonth(3).withHour(13).withMinute(30).withSecond(0);
        System.out.println("end="+ end.format(DateTimeFormatter.ISO_DATE_TIME));

        LocalDateTime target = LocalDateTime.of(2022, 2, 22, 22, 22, 22);
        boolean isBefore = now.isBefore(target);
        System.out.println("now:"+now);
        System.out.println("target:"+target);
        System.out.println("isBefore:"+isBefore);
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2022, 2, 22)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));

        // 时间转化为Datetime

        Date date=Date.from(end.atZone(ZoneId.of("UTC-8")).toInstant());
        System.out.println("date= "+ date);

    }
}
