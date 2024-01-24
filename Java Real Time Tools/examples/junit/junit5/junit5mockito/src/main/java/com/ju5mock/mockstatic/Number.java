package com.ju5mock.mockstatic;

import com.ju5mock.core.ArrayFinder;

public class Number {
    public int bigNumber(int[] inArray) {
        int[] sortedArray = ArrayHelper.sort(inArray);
        return sortedArray[sortedArray.length - 1];
    }
}
