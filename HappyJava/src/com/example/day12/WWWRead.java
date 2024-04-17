package com.example.day12;

import java.io.*;
import java.net.URL;

public class WWWRead {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.naver.com/");
            InputStream in = url.openStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String msg;
            while((msg = br.readLine()) != null)
                System.out.println(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
