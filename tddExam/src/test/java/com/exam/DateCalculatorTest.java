package com.exam;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateCalculatorTest {
    private DateCalculator dateCalculator;

    @BeforeEach
    // 테스트마다 실행해줄 메소드.
    // 메소드명은 실행에 있어서 의미가 없으므로 아무렇게나 지어도 괜찮다.
    // 다만 원할한 진행을 위해 직관적인 이름으로 하자.
    void setUp() {
        dateCalculator = new DateCalculator();
    }

    @Test
    void calculateAge(){
        LocalDate birthDate = LocalDate.of(1999, 3, 7);
        LocalDate currentDate = LocalDate.of(2024, 3, 18);
        int expectedAge = 25;
        assertEquals(expectedAge, dateCalculator.calculateAge(birthDate, currentDate));
    }

    @Test
    void calculateDaysBetween(){
        LocalDate startDate = LocalDate.of(2024, 3, 11);
        LocalDate endDate = LocalDate.of(2024, 3, 18);
        int expectedDate = 7;
        assertEquals(expectedDate, dateCalculator.calculateDaysBetween(startDate, endDate));
    }

    @Test
    void isLeapYear(){
        int leapYear = 2024;
        boolean isLeap = dateCalculator.isLeapYear(leapYear);
        assertEquals(true, isLeap);
    }
}
