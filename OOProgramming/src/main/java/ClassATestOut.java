import ch07.ClassA;

// ClassA를 상속받으면 접근가능 영역이 확장된다.
public class ClassATestOut extends ClassA{
    public int getNumber(){
        // 상속받아 number에 접근
        return number;
    }

    /* 패키지가 다르기 때문에 접근 불가
    public int getCount() {
        return count;
    }*/
    public static void main(String[] args) {
        ClassA a = new ClassA();
        // System.out.println(a.address);
        // private 이기 때문에, 다른 클래스에서 접근 불가능하다.
        // System.out.println(a.count); // package가 달라 접근 불가능
        // System.out.println(a.number); // protected 이기 때문에 접근 불가능
        System.out.println(a.name);
    }
}
