package ch07;

public class VendingTest {
    public static void main(String[] args) {
        VendingMachine.printVersion();  // 클래스 메소드

        //인스턴스
        VendingMachine vm = new VendingMachine();
        String pdt = vm.pushProductButton(1);   // 인스턴스 메소드
        System.out.println(pdt);

        double value = Math.random();
        System.out.println(value);

        System.out.println(ClassA.fieldA);  // 클래스필드 사용
        ClassA ca = new ClassA();
        System.out.println(ca.fieldB);  // 인스턴스화 하지 않으면 사용 불가능
    }
}
