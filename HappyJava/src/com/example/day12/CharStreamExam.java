package com.example.day12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamExam {
    public static void main(String[] args) {
        try (FileReader rd = new FileReader("a.txt");
             FileWriter wr = new FileWriter("c.txt");){
            int c;
            while ((c = rd.read()) != -1) {
                wr.write(c);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
