package com.ju5mock.mockstatic;

import java.util.Arrays;

public class ArrayHelper {
    public static int[] sort(int[] inArray) {
        return Arrays.stream(inArray).sorted().toArray();
    }
}
