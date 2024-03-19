package com.exam;
// static import
// lang처럼 Assertions.~ 를 생략할 수 있게 된다.
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

public class CalculatorTest {
    Calculator cal = null; //new Calculator(); 아래 BeforeEach에 객체를 선언하면 같은 역할을 할 수 있다.

    // 선언할때 aaa 이런식으로도 동작하나, 직관적인 이름으로 하자
    @Test
    void plus() {
        assertEquals(5, cal.plus(2, 3));
        assertEquals(11, cal.plus(5, 6));
    }

    @Test
    void minus() {
        assertEquals(1, cal.minus(4, 3));
        assertEquals(2, cal.minus(3, 1));
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("====BeforeAll 실행. 테스트 클래스가 실행될 때 한 번 실행됨. ");
    }

    @BeforeEach
    void beforeEach(){
        cal = new Calculator();
        System.out.println("===BeforeEach 실행. 테스트 메서드가 실행되기 전에 실행. " +
                "모든 테스트 메소드마다 매번 실행.");
    }

    @AfterEach
    void afterEach(){
        System.out.println("==AfterEach 실행. 각 테스트 메소드가 실행 된 후 실행.");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("====AfterAll 실행. 모든 테스트 메소드가 실행 된 후 실행");
    }

}
