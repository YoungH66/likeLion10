package com.example.tddExam;

public class CalTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int result = cal.plus(10, 20);

        /* Calculator plus method Test
        // plus Test
        System.out.println(result);
        System.out.println(cal.plus(5, 10));*/

        // minus Test
        System.out.println(cal.minus(20, 19));
    }
}
