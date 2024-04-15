package test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// String으로 받는거라 예외처리를 할 필요가 있을지 고민
public class WordCollectionExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();

        readWord(sc, wordList);
        removeQuit(wordList);
        printWordList(wordList);

        System.out.println("=========");
        System.out.println("Total number of words : " + numberOfWords(wordList));
        System.out.println("Total number of Charaters : " + numberOfLetters(wordList));
        System.out.println("The longest word : " + longestWord(wordList));
        sc.close();
    }

    public static void readWord(Scanner sc, List<String> strList) {
        System.out.println("Enter words...");
        System.out.println("Enter 'quit' to exit...");

        do{
            System.out.print("Enter word: ");
            strList.add(sc.nextLine());
            // quit은 String으로 Object로 들어가서 String.valueOf() 안써도 작동함
        }while(!strList.contains("quit"));
    }

    public static void removeQuit(List<String> strList) {
        strList.remove(("quit"));
    }

    public static void printWordList(List<String> strList) {
        System.out.println("::  Printing words in the List  ::");
        for(String word : strList) {
            System.out.println(word);
        }
    }

    public static int numberOfWords(List<String> strList) {
        return strList.size();
    }

    public static int numberOfLetters(List<String> strList) {
        int count = 0;
        for(int i = 0; i < strList.size(); i++) {
            for(int j = 0; j < strList.get(i).length(); j++) {
                count += 1;
            }
        }
        return count;
    }

    public static String longestWord(List<String> strList) {
        String longestWord = "";
        for(String word : strList) {
            if(word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
