package ch07;

public class MathBeanRunner {
    public static void main(String[] args) {
        MathBean mb = new MathBean();
        mb.printClassName();
        mb.printNumber(19);
        int result = mb.getOne();
        int result2 = mb.plus(4, 12);

        System.out.printf("result : %d\n", result);
        System.out.printf("result2 : %d", result2);

    }
}
