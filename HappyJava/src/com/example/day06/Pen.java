package com.example.day06;

import java.util.Objects;

public class Pen {
    int 잉크양;
    String 색상;

    public Pen(int 잉크양, String 색상) {
        this.잉크양 = 잉크양;
        this.색상 = 색상;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "잉크양=" + 잉크양 +
                ", 색상='" + 색상 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return 잉크양 == pen.잉크양 && Objects.equals(색상, pen.색상);
        // return Objects.equals(색상, pen.색상); 와 같이 구성하면 잉크양은 무시하고 색상만 같다면 같다고 판단한다.
    }

    // hashCode가 오버라이드 되어야 나중에 쓸 수 있음.
    @Override
    public int hashCode() {
        return Objects.hash(잉크양, 색상);
    }
}
