package com.ju5mock.core;

public class ArraySorter {
    public int[] sort(int[] inArray) {
        int[] sortedArray = inArray.clone();
        int temp = 0;

        for (int i = 0; i < sortedArray.length-1; i++) {
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
