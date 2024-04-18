package com.example.day13.threadExam;

import java.io.*;

public class FileReaderTask implements Runnable {
    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
