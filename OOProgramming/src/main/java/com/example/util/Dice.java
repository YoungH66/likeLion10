package com.example.util;

public class Dice {
    int face;
    public int roll(){
        return (int) (Math.random()*face);
    }

    public void setFace(int face) {
        this.face = face;
    }
}
