package com.ju5.core;

import java.util.stream.IntStream;

public class NumberHelper {
    public long addNOddNumbers(int n) {
        return IntStream.range(1, n).filter(NumberHelper::oddNumber).sum();
    }

    public long factorial(int n) {
        return IntStream.range(1, n+1).reduce(1, (submul, elem) -> {
            return submul * elem;
        });
    }

    private static boolean oddNumber(int i) {
        return i % 2 == 0 ? false : true;
    }

    public boolean isPrime(int n) {
        return IntStream.range(2, n / 2).noneMatch(i -> (n % i == 0));
    }
}
