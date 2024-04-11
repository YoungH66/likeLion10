package com.example.day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExam10 {
    public static void main(String[] args) {
        try {
            readFile("example.txt");
        }catch (IOException e){
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if(br != null) {
                br.close();
            }
        }
    }
}
