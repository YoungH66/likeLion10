package com.example.main;

import com.example.util.Lottery;

public class LotteryTest {
    public static void main(String[] args) {
        Lottery lotto = new Lottery();
        lotto.hitArrGen();
        lotto.popHitArr();

        lotto.tryArrGen();
        lotto.selectNum();
    }
}
