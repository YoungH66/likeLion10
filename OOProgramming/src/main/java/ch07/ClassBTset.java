package ch07;

public class ClassBTset{
    public void print(ClassB b){
        System.out.println(b.name);
        System.out.println(b.flg);
        System.out.println(b.address);
        System.out.println(b.age);
        //System.out.println(b.page);
    }



    public static void main(String[] args) {
        ClassBTset tet = new ClassBTset();
        tet.print(new ClassB());
    }
}
