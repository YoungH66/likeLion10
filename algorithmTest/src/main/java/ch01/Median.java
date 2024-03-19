package ch01;

public class Median {
    public static int midian(int a, int b, int c){
        if(a >= b)
            if(b >= c)
                return b;
            else if(a <= c)
                return a;
            else
                return c;
        else if(a > c)
            return a;
        else if(b > c)
            return c;
        else return b;
    }

    public static void main(String[] args) {
        System.out.println(midian(10, 20, 15));
        System.out.println(midian(20, 10, 15));

        System.out.println(midian(20, 15, 10));
        System.out.println(midian(10, 15, 20));

        System.out.println(midian(15, 10, 20));
        System.out.println(midian(15, 20, 10));

    }
}
