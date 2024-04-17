package com.example.day12.IOExam.multiTextManage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 사용자로부터의 입력을 담당
public class UserInputHandler {
    public List<String> getUserInput() {
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("텍스트를 입력(exit을 입력하면 입력을 완료합니다.): ");
            while(true) {
                String line = br.readLine();
                if(line.equals("exit")) {
                    break;
                }
                lines.add(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
}
