package com.exam;

import java.time.LocalDate;

public class DateCalculator {
    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return currentDate.getYear() - birthDate.getYear();
    }

    public int calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        return (int)startDate.until(endDate).getDays();
    }

    public boolean isLeapYear(int leapYear) {
        return LocalDate.ofYearDay(leapYear, 1).isLeapYear();
    }
}
