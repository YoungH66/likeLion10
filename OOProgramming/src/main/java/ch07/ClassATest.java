package ch07;

public class ClassATest {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        // System.out.println(a.address);
        // private 이기 때문에, 다른 클래스에서 접근 불가능하다.
        System.out.println(a.count);
        System.out.println(a.number);
        System.out.println(a.name);
    }
}
