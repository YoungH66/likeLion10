import java.util.Scanner;

// 백준 10810번 공 넣기
// https://www.acmicpc.net/problem/10810
public class youngH66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // nextInt는 사용자가 입력한 정수값 하나를 받는다. 개행문자 없이 띄어쓰기로 구분 가능
        // 혹은 nextLine을 통해 한줄에 입력 받을 수 있다.
        // 단 변수M을 사용하기 위해 nextInt 사용

        // 크기가 n인 배열과, 그 배열에 접근할 횟수인 m을 선언
        int[] arr = new int[sc.nextInt()];
        int M = sc.nextInt();

        for(int i = 0; i < M; i++) {
            int I = sc.nextInt();
            int J = sc.nextInt();
            int K = sc.nextInt();

            // 인덱스 시작은 0부터 이기때문에, 0보다 큰 수인 변수 I에 -1을 취해준다.
            for(int j = I - 1; j < J; j++){
                // arr[i]에 넣을 숫자인 변수 k를 넣는다.
                arr[j] = K;
            }
        }

        // 출력
        for(int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + " ");
        }
    }
}
