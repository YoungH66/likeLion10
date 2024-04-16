package com.example.day11;

import java.util.Objects;

public class Pen {
    String color;

    public Pen(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " pen";
    }

    // Set의 중복배제가 정상적으로 작동하기 위해선
    // 같은 값이라고 판단할 equals가 override 되어야 함.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}
