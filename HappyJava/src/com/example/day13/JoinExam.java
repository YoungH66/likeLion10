package com.example.day13;

public class JoinExam {
    public static void main(String[] args) {
        SumThread st = new SumThread();
        st.start();   // 계산 요청
        try {
            st.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //계산 결과가 나온 이후에 결과를 출력하고 싶을때, SumThread가 끝날때까지 기다리는 수단이 필요하다.
        System.out.println("Calculate result..");
    }
}

class SumThread extends Thread {
    @Override
    public void run() {
        // 계산을 하는 스레드
        try {
            sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Calculate Complete");
    }
}
