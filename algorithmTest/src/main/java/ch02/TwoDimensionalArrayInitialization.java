package ch02;

public class TwoDimensionalArrayInitialization {
    public static void main(String[] args) {
        // 3명의 학생과 각 학생의 4과목 점수를 초기화하면서 2차원 배열 선언
        int[][] scores = {
                {90, 80, 70, 60},
                {80, 40, 70, 50},
                {70, 80, 50, 10}
        };

        // 배열의 내용 출력
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "번째 학생의 과목 점수:");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println(scores[i][j]);
            }
            System.out.println();
        }

        // 배열의 합 출력
        for(int i = 0; i < scores.length; i++){
            System.out.print((i + 1) + "번째 학생의 과목 점수 총합 :");
            int sum = 0;
            for(int j = 0; j < scores[i].length; j++){
                sum += scores[i][j];
            }
            System.out.println(sum);
        }
    }
}
