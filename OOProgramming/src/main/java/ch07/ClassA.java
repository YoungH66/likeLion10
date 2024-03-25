package ch07;

public class ClassA {
    public static int fieldA;   // 클래스필드
    public int fieldB;  // 인스턴스 필드

    int count;
    protected int number;
    private  String address;
    public String name;

    public static void main(String[] args) {
        ClassA a = new ClassA();
        System.out.println(a.address);  // private 이지만, 같은 클래스이기 때문에 접근 가능하다.
        System.out.println(a.count);
        System.out.println(a.number);
        System.out.println(a.name);
    }
}
