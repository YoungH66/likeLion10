package ch07.pacTest;

import ch07.ClassB;
import ch07.ClassBTset;

public class ClassTest extends ClassB{
    public void print(ClassTest b){
        //System.out.println(b.name);
        System.out.println(b.flg);
        //System.out.println(b.address);
        //System.out.println(b.age);
        //System.out.println(b.page);
    }

    public static void main(String[] args) {
        ClassTest tet = new ClassTest();
        tet.print(tet);
    }
}