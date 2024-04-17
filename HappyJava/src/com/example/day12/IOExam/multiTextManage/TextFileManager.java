package com.example.day12.IOExam.multiTextManage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 파일 쓰기와 읽기 작업을 담당
public class TextFileManager {
    private String fileName;

    public TextFileManager(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(List<String> lines) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromFile() {
        List<String> lines = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
            while(line != null) {
                lines.add(line);
                line = br.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
