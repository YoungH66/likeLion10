package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class YoungH660320 {
    static int maxtri(int a, int b, int c){
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        return max;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        // 랜덤한 길이의 문제의 생성
        int[] ans = new int[rnd.nextInt(10000)];

        // 수포자들의 찍는 방식
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 맞춘 개수를 담을 배열
        int[] score = new int[3];

        // 문제 답안 랜덤 배정
        for(int i = 0; i < ans.length; i++){
            ans[i] = rnd.nextInt(1, 6);
        }

        // 정답 맞추기
        // 수포자들은 정답을 반복해서 찍기 때문에
        // 반복되는 크기만큼 나머지연산하면 해당 답안과 대조하여 정답여부를 확인할 수 있다.
        // 정답이면 해당 점수를 올린다.
        for(int i = 0; i < ans.length; i++){
            if(ans[i] == a[i % 5])
                score[0]++;
            if(ans[i] == b[i % 8])
                score[1]++;
            if(ans[i] == c[i % 10])
                score[2]++;
        }

        // 가장 많이 맞춘 개수를 구한다.
        int maxScr = maxtri(score[0], score[1], score[2]);

        List<Integer> answ = new ArrayList<Integer>();
        for(int i = 0; i < score.length; i++)
            if(maxScr == score[i])
                answ.add(i + 1);

        int[] answer = new int[answ.size()];
        for(int i = 0; i < answ.size(); i++)
            answer[i] = answ.get(i);

        for(int i = 0; i < answer.length; i++)
            System.out.print(answer[i]);
        }
    }
