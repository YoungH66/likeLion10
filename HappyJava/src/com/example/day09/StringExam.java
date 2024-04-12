package com.example.day09;

public class StringExam {
    //물품번호를 받아들여서 물품번호규칙에 맞으면 true,
    // 아니면 false를 리턴하는 메소드를 완성하세요.
    // 조건1. 물품번호의 길이는 6이다.
    // 조건2. 물품번호의 1,2 번째 자리는 알파벳이어야 한다. (대소문자 모두 가능)
    // 조건3. 물품번호의 3-6 자리수는 숫자만 가능하다.

    public boolean checkProductNumber(String productNumber) {
        // 문자열 길이 확인
        if (productNumber.length() != 6)
            return false;

        char firstChar = productNumber.charAt(0);
        char secondChar = productNumber.charAt(1);

        // 첫 번째 문자와 두 번째 문자 확인
        if (!Character.isLetter(firstChar) || !Character.isLetter(secondChar))
            return false;

        // 나머지 문자 확인
        for (int i = 2; i < productNumber.length(); i++) {
            if (!Character.isDigit(productNumber.charAt(i)))
                return false;
        }

        // 모든 조건을 통과하면 true 반환
        return true;
    }

    public static void main(String[] args) {
        StringExam se = new StringExam();
        System.out.println(se.checkProductNumber("te3456")); // true
        System.out.println(se.checkProductNumber("t33456")); //false
        System.out.println(se.checkProductNumber("ar49786"));//false
        System.out.println(se.checkProductNumber("test56"));//false
    }
}
