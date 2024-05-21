package test;

import java.io.*;
import java.util.StringTokenizer;

public class test0521 {
    public static void main(String[] args) {

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ){
            // StringTokenizer 사용.
            // 빠름
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int maxNum = -1000000;
                int minNum = 1000000;
                for(int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num > maxNum) {
                        maxNum = num;
                    }
                    if(num < minNum) {
                        minNum = num;
                    }
                }
                System.out.println(minNum + " " + maxNum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
