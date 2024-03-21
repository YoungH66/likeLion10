package ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BodyExamSearchDemo {
    static class BodyData{
        private String name;
        private int height;
        private double weight;

        public BodyData(String name, int height, double weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return name + " " + height + "cm " + weight + "kg";
        }

        public static final Comparator<BodyData> HEIGHT_COMPARATOR = new HeightComparator();

        private static class HeightComparator implements Comparator<BodyData> {
            @Override
            public int compare(BodyData o1, BodyData o2) {
                return Integer.compare(o1.height, o2.height);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        BodyData[] data = {
                new BodyData("김지수", 162, 52.5),
                new BodyData("이민준", 168, 68.4),
                new BodyData("박서준", 171, 72.0),
                new BodyData("최윤기", 174, 85.5),
                new BodyData("정하늘", 177, 77.0),
                new BodyData("한지안", 180, 88.5)
        };

        System.out.print("찾고 싶은 사람의 키를 입력하세요(cm) : ");
        int searchHeight = stdIn.nextInt();

        int idx = Arrays.binarySearch(
                data,
                new BodyData("", searchHeight, 0),
                BodyData.HEIGHT_COMPARATOR
        );

        if(idx < 0) {
            System.out.println("해당 키를 가진 데이터가 없습니다.");
        }else {
            System.out.println("해당 데이터는 data[" + idx + "]에 있습니다.");
            System.out.println("찾는 데이터 : " + data[idx]);
        }
    }
}
