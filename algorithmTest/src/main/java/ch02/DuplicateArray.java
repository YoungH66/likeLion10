package ch02;

public class DuplicateArray {
    // 데이터 타입
    public static int[] change(int[] copied){
        copied[2] = 10;
        return copied;
    }
    public static void main(String[] args) {
        int[] origin = {10, 20, 30, 40, 50};
        // int[] copied = origin.clone(); // int[] 을 반환한다. 래퍼런스 타입
        /*copied[2] = 0;
        */
        int [] copied = change(origin);

        System.out.println(origin[2]);
        System.out.println(copied[2]);
    }
}
