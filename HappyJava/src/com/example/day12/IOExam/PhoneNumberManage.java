package com.example.day12.IOExam;

import java.io.*;
import java.util.*;

class PhoneNumber implements Serializable {
    private String name;
    private String number;

    public PhoneNumber(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return name + " " + number;
    }
}
public class PhoneNumberManage {
    public static void main(String[] args) {
        // 배열을 만들어서 할려 했지만 실패
        //ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();

        try(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileOutputStream("c:\\temp\\phone.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("c:\\temp\\phone.txt"));
        ){

            System.out.print("입력하기 원하는 인원수를 입력 : ");
            int n = Integer.parseInt(br.readLine());
            while(n-- > 0){
                System.out.print("이름 : ");
                String name = br.readLine();
                System.out.print("전화번호 : ");
                String number = br.readLine();

                pw.println(name + " " + number);
            }
            pw.close();
            System.out.println("... 전화번호가 c:\\temp\\phone.txt에 저장되었습니다.\n");

            System.out.println("c:\\temp\\phone.txt의 내용은 다음과 같습니다...");
            String line;
            while((line = br2.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
