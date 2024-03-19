package ch02;

public class DecimalToBinaryExam {
    public static void main(String[] args) {
        int dec = 29;
        int origindec = dec;
        // String 객체는 불변 객체로, 한번 정의되면 수정이 불가능하다.
        // 수정이 필요할 경우 다음을 사용할 수 있다.
        StringBuilder bin = new StringBuilder();
        int remainder;
        while(dec > 0) {
            remainder = dec % 2;
            dec = dec / 2;
            System.out.println("remainder : " + remainder);
            bin.append(remainder); // 하나씩 붙인다.
        }

        System.out.println("dec(" + origindec + ") to bin : " + bin.reverse().toString());
    }
}
