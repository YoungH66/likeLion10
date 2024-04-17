package com.example.day12.IOExam.multiTextManage;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String filePath = "texts.txt";
        TextFileManager fileManager = new TextFileManager(filePath);
        UserInputHandler inputHandler = new UserInputHandler();

        List<String> userInput = inputHandler.getUserInput();
        fileManager.writeToFile(userInput);

        List<String> fileContent = fileManager.readFromFile();
        System.out.println("Content of the file:");
        fileContent.forEach(System.out::println);
    }
}
