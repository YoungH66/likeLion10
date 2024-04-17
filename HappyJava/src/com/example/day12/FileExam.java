package com.example.day12;

import java.io.File;

public class FileExam {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir")); // user.dir 도 현재 디렉토리
        File dir = new File("."); // .은 현재 디렉토리를 의미
        String[] files = dir.list();

        for(String file : files) {
            System.out.println(file);
        }
    }
}
