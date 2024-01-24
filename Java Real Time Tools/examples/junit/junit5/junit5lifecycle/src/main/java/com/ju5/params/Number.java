package com.ju5.params;

import java.util.stream.IntStream;

public class Number {
    public boolean isPrimeNumber(int n) {
        boolean prime = true;

        prime = IntStream.range(2, n / 2).noneMatch(i -> n % i == 0);
        return prime;
    }

    public int substract(int a, int b) {
        return b - a;
    }
}
