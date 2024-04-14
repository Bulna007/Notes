package com.ju5mock.core;

import com.ju5mock.exception.EmptyArrayException;

public class ArraySorter {
    public int[] sort(int[] inArray) throws EmptyArrayException {

        if (inArray == null || inArray.length == 0) {
            throw new EmptyArrayException("input array is empty or null");
        }

        int[] sortedArray = inArray.clone();
        int temp = 0;


        System.out.println("ArraySorter::sort");
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - 2 - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}
