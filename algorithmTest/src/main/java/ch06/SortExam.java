package ch06;

import java.util.Arrays;
import java.util.Random;

public class SortExam {
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void bubbleSort(int[] arr){
        System.out.println("\nBubbleSort :::::::");
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            System.out.println((i + 1) + "번째 정렬..." + Arrays.toString(arr));
        }
        System.out.println("...");

    }

    public static void selectionSort(int[] arr) {
        System.out.println("\nSelectionSort :::::::");
        for(int i = 0; i < arr.length - 1; i++){
            // 최소값을 찾는다.
            int min = i;    // 대상 인덱스
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);
            System.out.println((i + 1) + "번째 정렬..." + Arrays.toString(arr));
        }
        System.out.println("...");
    }
    public static void main(String[] args) {
        Random rn = new Random();
        int[] arr = new int[rn.nextInt(5,10)];
        for(int i = 0; i < arr.length; i++)
            arr[i] = rn.nextInt(500);

        System.out.println("ORIGIN ARRAY : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("SORTED ARRAY(BUBBLE) : " + Arrays.toString(arr));

        System.out.println();

        selectionSort(arr);
        System.out.println("SORTED ARRAY(SELECTION) : " + Arrays.toString(arr));
        // test0328과 비교
    }
}
