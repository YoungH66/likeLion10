package com.example.day12;

import java.io.*;

public class ObjectStreamExam {
    public static void main(String[] args) {
        /* 객체 내보내기
        Person p = new Person("kim", 26);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"));){
            oos.writeObject(p);
        }catch(IOException e){
            e.printStackTrace();
        }*/

        // 파일에서 객체 읽어오기
        Person readPerson = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"));){
            // 알맞는 객체로 형변환 필요
            readPerson = (Person)ois.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(readPerson);
        System.out.println(readPerson.getName());
        System.out.println(readPerson.getAge());
        // 가져온 객체를 readPerson에 저장했기 때문에 person.dat의 원본데이터는 영향을 받지 않음
        readPerson.setName("Young");
        readPerson.setAge(23);
        System.out.println(readPerson);
    }
}
