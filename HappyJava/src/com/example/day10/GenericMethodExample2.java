package com.example.day10;

public class GenericMethodExample2 {
    // Number 인터페이스를 extends 했기 때문에
    // 본래 object만 사용가능했지만, 이 경우 Number도 사용 가능해진다.
    public static <T extends Number> T max(T x, T y, T z) {
        T max = x;
        if(y.doubleValue() > max.doubleValue())
            max = y;
        if(z.doubleValue() > max.doubleValue())
            max = z;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(1, 2, 3));
        System.out.println(max(4, 2, 15));
        System.out.println(max(123, 2, 5));
        System.out.println(max(2, 142, 1));
        System.out.println(max(13.4, 29, 5.8));
        System.out.println(max(13, 29.4, 5.8));
    }
}
