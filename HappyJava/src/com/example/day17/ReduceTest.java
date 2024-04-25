package com.example.day17;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // a는 초기값, b가 꺼내온 값으로 시작한다.
        // 마치 재귀함수처럼 앞선 값을 다음 값으로 사용한다.
        // a = 0 b = 1에서 시작해서 다음은 a = 1 b = 2로 3, 다음은 a = 3 b = 3으로 6.. 이와같이 동작한다.
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        List<Member> members = Arrays.asList(
          new Member("YoungH", 30),
          new Member("Kim", 40),
          new Member("Mike", 50),
          new Member("lee", 80),
          new Member("Jack", 100)
        );

        // Member 들의 score 총합을 구한다.
        int memberScoreSum = members.stream().mapToInt(Member::getScore).sum();
        System.out.println(memberScoreSum);

        // reduce 사용하는 경우
        int memberScoreSum2 = members.stream().mapToInt(Member::getScore).reduce(0, (a, b) -> a + b);
        System.out.println(memberScoreSum2);

        // reduce에 초기값을 주지 않은 경우
        int memberScoreSum3 = members.stream().mapToInt(Member::getScore).reduce((a, b) -> a + b).getAsInt();
        System.out.println(memberScoreSum3);
    }
}
