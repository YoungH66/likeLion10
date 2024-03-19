package com.exam;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {

    // 한글 주석이 포함되었을경우, unmappable character for encoding 에러가 발생한다.
    // gradle에 옵션으로 다음과 같이 추가하니 해결되었다. encoding을 UTF-8로 하니 한글도 포함되는듯 하다.
    //compileJava.options.encoding = 'UTF-8'
    //compileTestJava.options.encoding = 'UTF-8'

    @Test
    void subString() {
        String str = "abcdef";
        assertEquals("cd", str.substring(2, 4));
    }
}
