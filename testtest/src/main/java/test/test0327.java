package test;
// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
// 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

// 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
// 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
// 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데,
// 이 수들이 A안에 존재하는지 알아내면 된다.
// 모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.

// *로 다 포함하게
import java.io.*;
import java.util.*;
// M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
public class test0327 {
    static final int minNum = 1;
    static final int maxNum = 100000;
    // BufferReader 를 사용해서 IOException이 발생할 수 있어서 선언해주어야 함.
    public static void main(String[] args) throws IOException {
        // 입력 스트림을 버퍼에 저장하고 효율적으로 읽을 수 있다.
        // InputStreamReader는 바이트 입력 스트림을 문자 입력 스트림으로 변환한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());;

        /*// 범위를 초과하면 다시 입력
        do{
            N = Integer.parseInt(br.readLine());
        }while(N > maxNum || N < minNum);
        */
        int arr[] = new int[N];


        // StringTokenizer는 문자열을 구분자를 기준으로 분리하는데 사용됨.
        // 입력을 " " 로 구분
        st = new StringTokenizer(br.readLine(), " ");
        // 구분한거 하나씩 배열에 넣기
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        /*int tgArr[] = new int[M];*/
        // M이 0보다 큰 동안(M-- > 0) 반복되며, 각 반복에서는 StringTokenizer를 사용하여 공백이나 다른 구분자를 기준으로
        // 문자열을 토큰으로 분리하여 정수형으로 변환합니다.
        // 이 정수 값을 target 변수에 저장한 후, arr 배열에서 target 값을 이진 검색하여 해당 값의 인덱스를 찾습니다.
        // 이 인덱스를 문자열에 추가한 후, 결과 문자열에 개행 문자("\n")를 덧붙입니다.

        while (M-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, target, 0, N - 1)).append("\n");
        }

        /*for(int i = 0; i < arr.length; i++){
            tgArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tgArr);*/

        /*for(int i = 0; i < arr.length; i++){
            int index = Arrays.binarySearch(arr, tgArr[i]);
            if(index < 0)
                System.out.println("-1");
            else System.out.println("1");
        }*/
        System.out.println(sb);
    }
    // 이진 탐색 메소드
    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
