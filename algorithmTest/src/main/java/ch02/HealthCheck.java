package ch02;

import java.util.Scanner;

public class HealthCheck {
    static final int PMAX = 16; // 혈압의 분포 (60부터 10 단위로 16개)

    static class HealthData{
        String name; // 이름
        int weight; // 체중
        double bloodPressure; // 혈압

        HealthData(String name, int weight, double bloodPressure){
            this.name = name;
            this.weight = weight;
            this.bloodPressure = bloodPressure;
        }
    }

    // 체중의 평균값을 구함
    static double aveWeight(HealthData[] dat){
        double sum = 0;

        for(int i = 0; i < dat.length; i++)
            sum += dat[i].weight;

        return sum/ dat.length;
    }

    // 혈압의 분포를 구함
    static void distBloodPressure(HealthData[] dat, int[] dist) {
        for(int i = 0; i < dat.length; i++) {
            if(dat[i].bloodPressure >= 60.0 && dat[i].bloodPressure <= 150.0)
                dist[(int)(dat[i].bloodPressure / 10) - 6]++;
        }
    }

    public static void main(String[] args) {
        HealthData[] x = {
                new HealthData("홍길동", 74, 128.0),
                new HealthData("이순신", 85, 115.0),
                new HealthData("장보고", 95, 99.0),
                new HealthData("유관순", 65, 102.0),
                new HealthData("김구", 78, 120.0),
                new HealthData("안중근", 88, 130.0),
                new HealthData("박문수", 77, 140.0),
        };
        int[] bpdist = new int[PMAX]; // 혈압의 분포

        System.out.println("■ 건강검진 리스트 ■");
        System.out.println(" 이름\t\t체중\t\t혈압");
        System.out.println("--------------------");
        for (int i = 0; i < x.length; i++)
            // x 배열의 i번째 요소에서 name, weight, bloodPressure 값을 포맷하여 출력한다.
            // name은 왼쪽 정렬된 6글자의 문자열. '-6s' 는 '-'로 왼쪽 정렬를, '6s'로 최소 폭이 6글자인 문자열을 의미
            // weight는 3글자의 정수
            // bloodPressure는 소수점 이하 한 자리를 포함한 총 5글자의 부동 소수점 수로 출력
            System.out.printf("%-6s\t%3d\t\t%5.1f\n",
                    x[i].name, x[i].weight, x[i].bloodPressure);

        System.out.printf("\n평균 체중: %5.1fkg\n", aveWeight(x));

        distBloodPressure(x, bpdist); // 혈압의 분포를 구함

        System.out.println("\n혈압 분포");
        for (int i = 0; i < PMAX; i++)
            if(bpdist[i] > 0)
                System.out.printf("%3.1f～: %2d명\n", (i + 6) * 10.0, bpdist[i]);
    }
}
