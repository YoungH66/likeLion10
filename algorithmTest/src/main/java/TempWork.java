import java.util.Arrays;
import java.util.Scanner;

public class TempWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        int[] arr = new int[cap];
        int n = 0;
        do{
            arr[n++] = sc.nextInt();
        }while(n != cap);

        Arrays.sort(arr);
        for(int i = 0; i < cap; i++)
            System.out.println(arr[i]);
    }
}
