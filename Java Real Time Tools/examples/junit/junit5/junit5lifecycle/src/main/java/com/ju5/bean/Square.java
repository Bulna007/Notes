package com.ju5.bean;

public class Square {
    public int area(int side) {
        if(side < 0) {
            throw new IllegalArgumentException("side should be positive-integer or zero");
        }
        return side * side;
    }
}
