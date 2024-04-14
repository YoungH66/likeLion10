package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class test0414 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        List<Integer> arr = new ArrayList<Integer>();
        System.out.println(cal);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int first = year * month;
        int second = year * day;
        int third = month * day;
        int fourth = year + month;
        int fifth = year + day;
        int sixth = month + day;

        first = rand(first);
        second = rand(second);
        third = rand(third);
        fourth = rand(fourth);
        fifth = rand(fifth);
        sixth = rand(sixth);

        arr.add(first);
        arr.add(second);
        arr.add(third);
        arr.add(fourth);
        arr.add(fifth);
        arr.add(sixth);
        System.out.println(arr);
    }

    static public int rand(int num) {
        int ran;
        while(num > 45) {
            ran = (int) (Math.random() * 45 - 1);
            num = num % ran;
            ran = (int) (Math.random() * 45 - 1);
            num = num + ran;
        }
        return num;
    }
}
