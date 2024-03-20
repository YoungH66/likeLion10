package ch03;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.Random;

public class SearchExam {
    static int sequentialSearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key)
                return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == k)
                return mid;
            else if(arr[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static void resultPrint(int val){
        if(val != -1)
            System.out.println("목표 데이터는 " + (val+1) + "번째 인덱스에 위치하고 있음");
        else
            System.out.println("목표 데이터가 해당 배열에 존재하지 않음.");
    }

    public static void main(String[] args) {
        Random ran = new Random();
        int[] iarr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 33, 45, 85, 99};
        int index = sequentialSearch(iarr, 33);
        resultPrint(index);
        index = binarySearch(iarr, 33);
        resultPrint(index);
        System.out.println();

        // 난수를 배열에 저장하여 찾는 경우
        int[] rnArr = new int[ran.nextInt(5, 50)];
        for(int i = 0; i < rnArr.length; i++){
            rnArr[i] = ran.nextInt(100);
        }
        // 정렬 안하면 이진 탐색은 결과가 안나옴.
        Arrays.sort(rnArr);
        resultPrint(sequentialSearch(rnArr, 50));
        resultPrint(binarySearch(rnArr, 50));
    }
}
