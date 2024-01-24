package com.ju5.core;

import java.util.Arrays;

public class ArrayHelper {
    int bigNumber(int[] inArray) {
        int bigNumber = Arrays.stream(inArray).reduce(0, (max, number) -> {
            if (max < number) {
                return number;
            }
            return max;
        });

        return bigNumber;
    }
}
