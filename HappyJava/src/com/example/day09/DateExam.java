package com.example.day09;

import java.util.Calendar;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) {
        Date date = new Date();
        Date date2 = new Date(2020, 0, 1);
        System.out.println(date);
        System.out.println(date2);
        System.out.println(date.after(date2));
        System.out.println(date.before(date2));
        System.out.println(date.getTime());

        Calendar calendar = Calendar.getInstance(); // Calendar는 new로 객체 생성 불가능
        System.out.println(calendar);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Year: " + year + " Month: " + month + " Day: " + day);

        calendar.set(1999, 2, 7);
        calendar.add(Calendar.DATE, 1);
    }
}
