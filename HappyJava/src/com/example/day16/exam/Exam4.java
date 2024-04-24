package com.example.day16.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Exam4 {
    // 랜덤한 정수를 얻어내기 위한 Supplier
    static Supplier<Integer> ranInt = () -> (int) (Math.random() * 10) + 1;

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        // 문자열 배열
        String[] strArr = genRandStrArr(ranInt.get());
        // 몇 글자인지 확인하기 위한 배열
        List<Integer> idxArr = new ArrayList<>();
        // 결과를 저장할 배열
        List<String> resultArr = new ArrayList<>();

        System.out.println(Arrays.toString(strArr));

        // 문자열 배열의 길이를 반환할 Function
        Function<String, Integer> lenFunc = String::length;
        for(String word : strArr){
            idxArr.add(lenFunc.apply(word));
            if(lenFunc.apply(word) >= 5)
                resultArr.add(word);
        }
        System.out.println(idxArr);

        if (!resultArr.isEmpty()) {
            System.out.println("글자수가 5 이상인 첫 단어 : " + resultArr.get(0));
        } else {
            System.out.println("글자수가 5 이상인 단어가 없습니다.");
        }
    }

    public static String genRanStr(int length){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // 알파벳 배열의 무작위 인덱스 번호를 가져오고
            int index = rand.nextInt(CHARACTERS.length());
            // 해당 알파벳을 덧붙인다.
            sb.append(CHARACTERS.charAt(index));
        }
        // 완성된 문자열을 반환
        return sb.toString();
    }

    public static String[] genRandStrArr(int size) {
        String[] strArr = new String[size];

        for(int i = 0; i < size; i++){
            // 랜던한 크기의 문자열을 받아와서 해당 인덱스에 저장
            strArr[i] = genRanStr(ranInt.get());
        }
        // 완성된 문자열 배열을 반환
        return strArr;
    }
}
