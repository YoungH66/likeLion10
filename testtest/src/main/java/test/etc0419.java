package test;

import java.io.*;

public class etc0419 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fos = new FileOutputStream("do.txt");
            FileWriter fw = new FileWriter("do1.txt");){
            String line;
//            while(!(line = br.readLine()).equals("exit")){
//                fos.write(line.getBytes());
//            }
            System.out.println("Input any words..");
            System.out.println("'exit' to quit");
            do{
                System.out.print("Enter a content: ");
                line = br.readLine();
                fw.write(line + "\r\n");
            }
            while(!line.equals("exit"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
