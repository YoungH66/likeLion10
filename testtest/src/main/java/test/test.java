package test;

public class test {
    public static void main(String[] args) {
        // 배열 생성
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        // 인덱스 순회 패턴 설정
        int[] indexPattern = {3, 6, 2, 7, 5, 1, 4};

        // 인덱스 증가 및 순회
        for (int i = 0; i < indexPattern.length; i++) {
            int index = indexPattern[i] - 1; // 배열의 인덱스는 0부터 시작하므로 패턴에 맞게 조정
            int adjustedIndex = index % array.length; // 배열의 길이로 나눈 나머지를 새로운 인덱스로 사용
            int element = array[adjustedIndex];
            System.out.println("Element at Adjusted Index " + adjustedIndex + ": " + element);
        }
    }
}
