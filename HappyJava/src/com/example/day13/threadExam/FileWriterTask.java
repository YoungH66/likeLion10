package com.example.day13.threadExam;

import java.io.*;

public class FileWriterTask implements Runnable{
    @Override
    public void run() {
        try(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("output.txt")){
            System.out.println("input data start..");
            System.out.println("'quit' to exit..");
            String data = null;
            do {
                System.out.print("input somthing : ");
                data = br.readLine();
                fw.write(data + '\n');
            }while(!data.equals("quit"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
