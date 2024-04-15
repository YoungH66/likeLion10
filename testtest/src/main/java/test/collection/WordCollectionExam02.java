package test.collection;

// 최적화

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCollectionExam02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();

        readWords(sc, wordList);
        printWordList(wordList);

        System.out.println("=========");
        System.out.println("Total number of words : " + numberOfWords(wordList));
        System.out.println("Total number of Characters : " + numberOfLetters(wordList));
        System.out.println("The longest word : " + longestWord(wordList));
        sc.close();
    }

    public static void readWords(Scanner sc, List<String> wordList) {
        System.out.println("Enter words...");
        System.out.println("Enter 'quit' to exit...");

        // removeQuit 메소드를 따로 생성하지 않고 반복문을 끝내면 된다.
        while (true) {
            System.out.print("Enter word: ");
            String input = sc.nextLine();
            if (input.equals("quit")) {
                break;
            }
            wordList.add(input);
        }
    }

    public static void printWordList(List<String> wordList) {
        System.out.println("::  Printing words in the List  ::");
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    public static int numberOfWords(List<String> wordList) {
        return wordList.size();
    }

    public static int numberOfLetters(List<String> wordList) {
        int count = 0;
        // 단어 하나씩 돌면서 문자개수를 세는거보다
        // 그냥 한 단어의 길이를 더하면 된다.
        for (String word : wordList) {
            count += word.length();
        }
        return count;
    }

    public static String longestWord(List<String> wordList) {
        String longestWord = "";
        for (String word : wordList) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}